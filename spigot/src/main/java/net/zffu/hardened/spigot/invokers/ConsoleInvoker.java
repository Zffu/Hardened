package net.zffu.hardened.spigot.invokers;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.bukkit.command.CommandSender;

/**
 * A {@link CommandInvoker} that is also a {@link org.bukkit.command.ConsoleCommandSender}.
 * @since 1.0.0
 */
public class ConsoleInvoker implements CommandInvoker {

    private CommandSender sender;

    public ConsoleInvoker(CommandSender sender) {
        this.sender = sender;
    }

    public InvokerType getType() {
        return InvokerType.CONSOLE;
    }

    public boolean hasPermission(String permission) {
        return this.sender.hasPermission(permission);
    }
}
