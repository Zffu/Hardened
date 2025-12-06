package net.zffu.hardened.shared;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Implementation of {@link CommandSender} for Spigot & Paper</p>
 */
public class SharedConsoleInvoker implements CommandInvoker {

    public final CommandSender sender;

    public SharedConsoleInvoker(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public @NotNull InvokerType getType() {
        return InvokerType.CONSOLE;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(String message) {
        this.sender.sendMessage(message);
    }
}
