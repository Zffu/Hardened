package net.zffu.hardened.spigot.handler;

import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.shared.SharedInvokerFactory;
import net.zffu.hardened.spigot.registrar.SpigotCommandRegistrar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * <p>A handler for {@link net.zffu.hardened.api.commands.Command}.</p>
 * @since 1.0.0
 */
public class SpigotCommandHandler implements CommandExecutor {

    private SpigotCommandRegistrar registrar;
    private net.zffu.hardened.api.commands.Command<?> command;
    private boolean parseArgs;

    public SpigotCommandHandler(net.zffu.hardened.api.commands.Command<?> command, SpigotCommandRegistrar registrar) {
        this.command = command;
        this.parseArgs = !this.command.getArguments().getArguments().isEmpty();
        this.registrar = registrar;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandInvoker invoker = sender instanceof Player ? this.registrar.instance.getPlayerInvoker(((Player) sender).getUniqueId()) : this.registrar.instance.consoleInvoker;

        CommandContext context = new CommandContext(invoker, (this.parseArgs ? CommandContext.preFormatArguments(this.command, args) : null), label);
        this.command.run(context);

        return true;
    }

}
