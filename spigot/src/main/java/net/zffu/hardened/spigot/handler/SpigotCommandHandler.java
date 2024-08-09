package net.zffu.hardened.spigot.handler;

import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.spigot.registrar.SpigotCommandRegistrar;
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
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandContext context = new CommandContext(fromCommandSender(sender), (this.parseArgs ? CommandContext.preFormatArguments(this.command, args) : null), label);
        this.command.run(context);
        return true;
    }

    /**
     * Turns a {@link CommandSender} into a {@link CommandInvoker}.
     * @param sender the {@link CommandSender}
     * @return the {@link CommandInvoker}
     */
    public CommandInvoker<CommandSender> fromCommandSender(CommandSender sender) {
        InvokerType type = (sender instanceof Player ? InvokerType.PLAYER : (sender instanceof ConsoleCommandSender ? InvokerType.CONSOLE : InvokerType.OTHER));
        return this.registrar.factory.createInvoker(sender, type);
    }

}
