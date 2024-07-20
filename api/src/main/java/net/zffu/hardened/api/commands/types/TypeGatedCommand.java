package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.invoker.InvokerType;

import java.util.Collection;

/**
 * A {@link net.zffu.hardened.api.commands.Command} that can onlu run with specific {@link net.zffu.hardened.api.invoker.InvokerType}.
 * @since 1.0.0
 */
public interface TypeGatedCommand {

    /**
     * Gets the list of the {@link InvokerType} that are allowed to run the command.
     * @return {@link InvokerType}.
     */
    Collection<InvokerType> getAllowedInvokers();

}
