package net.zffu.hardened.bungeecord;

import net.md_5.bungee.api.CommandSender;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Implementation of {@link CommandSender} for Bungeecord console</p>
 * @since 1.0.0
 */
public class BungeeConsoleInvoker implements CommandInvoker {

    private final CommandSender sender;

    public BungeeConsoleInvoker(CommandSender sender) {
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
