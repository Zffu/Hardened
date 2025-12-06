package net.zffu.hardened.spigot.handler;

import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Command handler for reflection approach.
 * @since 1.0.0
 */
public class SpigotCommand extends Command {

    private net.zffu.hardened.api.commands.Command command;
    private final CommandRegistrar registrar;
    private boolean parseArgs;

    public SpigotCommand(net.zffu.hardened.api.commands.Command command, CommandRegistrar registrar) {
        super(command.getPrimaryName());
        this.command = command;
        this.registrar = registrar;

        if(this.command.getAliases() != null && this.command.getAliases().length > 0) this.setAliases(Arrays.asList(this.command.getAliases()));
        this.parseArgs = !this.command.getArguments().getArguments().isEmpty();
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        CommandInvoker invoker = sender instanceof Player ? this.registrar.instance.getPlayerInvoker(((Player) sender).getUniqueId()) : this.registrar.instance.consoleInvoker;

        CommandContext context = new CommandContext(invoker, (this.parseArgs ? CommandContext.preFormatArguments(this.command, args) : null), commandLabel);
        this.command.run(context);
        return true;
    }
}
