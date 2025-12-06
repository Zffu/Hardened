package net.zffu.hardened.bungeecord;

import net.md_5.bungee.api.CommandSender;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A bungeecord command invoker</p>
 * @since 1.0.0
 */
public class BungeeInvoker implements CommandInvoker {

    private final CommandSender sender;
    private final InvokerType type;

    public BungeeInvoker(CommandSender sender) {
        this.sender = sender;
        this.type = InvokerType.PLAYER;
    }

    public BungeeInvoker(CommandSender sender, InvokerType type) {
        this.sender = sender;
        this.type = type;
    }

    @Override
    public @NotNull InvokerType getType() {
        return this.type;
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
