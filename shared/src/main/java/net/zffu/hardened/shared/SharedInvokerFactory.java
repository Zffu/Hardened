package net.zffu.hardened.shared;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerFactory;
import net.zffu.hardened.api.invoker.InvokerType;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Invoker factory for Spigot, Paper</p>
 * @since 1.0.0
 */
public class SharedInvokerFactory implements InvokerFactory<CommandInvoker<CommandSender>, CommandSender> {

    @Override
    public CommandInvoker<CommandSender> createInvoker(CommandSender sender, InvokerType type) {
        return new CommandInvoker<CommandSender>() {

            @Override
            public @NotNull InvokerType getType() {
                return type;
            }

            @Override
            public boolean hasPermission(@NotNull String permission) {
                return sender.hasPermission(permission);
            }

            @Override
            public CommandSender getSender() {
                return sender;
            }

            @Override
            public void sendMessage(String message) {
                sender.sendMessage(message);
            }

        };
    }
}
