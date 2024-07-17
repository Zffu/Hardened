package net.zffu.hardened.spigot.invokers;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.bukkit.command.CommandSender;

/**
 * An {@link CommandInvoker} on which the type couldn't be determined.
 */
public class OtherInvoker implements CommandInvoker {

    private CommandSender commandSender;

    /**
     * Constructs an new {@link OtherInvoker}.
     * @param sender
     */
    public OtherInvoker(CommandSender sender) {
        this.commandSender = sender;
    }

    public InvokerType getType() {
        return InvokerType.OTHER;
    }

    public boolean hasPermission(String permission) {
        return this.commandSender.hasPermission(permission);
    }
}