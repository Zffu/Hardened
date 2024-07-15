package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.invoker.InvokerType;

/**
 * A {@link net.zffu.hardened.api.commands.Command} that can onlu run with specific {@link net.zffu.hardened.api.invoker.InvokerType}.
 * @since 0.0.1
 */
public interface TypeGatedCommand {

    /**
     * Gets the list of the {@link InvokerType} that are allowed to run the command.
     * @return {@link InvokerType}.
     */
    InvokerType[] getAllowedInvokers();

}
