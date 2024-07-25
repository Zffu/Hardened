package net.zffu.hardened.spigot.handler;

import net.zffu.hardened.api.context.CommandContext;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

/**
 * Command handler for reflection approach.
 * @since 1.0.0
 */
public class SpigotCommand extends Command {

    private net.zffu.hardened.api.commands.Command command;
    private boolean parseArgs;

    public SpigotCommand(net.zffu.hardened.api.commands.Command command) {
        super(command.getPrimaryName());
        this.command = command;
        if(this.command.getAliases() != null && this.command.getAliases().length > 0) this.setAliases(Arrays.asList(this.command.getAliases()));
        this.parseArgs = !this.command.getArguments().getArguments().isEmpty();
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        CommandContext context = new CommandContext(SpigotCommandHandler.fromCommandSender(sender), (this.parseArgs ? CommandContext.preFormatArguments(this.command, args) : null), commandLabel);
        this.command.run(context);
        return true;
    }
}
