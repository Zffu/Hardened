package net.zffu.hardened.api.invoker;

import org.jetbrains.annotations.NotNull;

/**
 * The invoker of a {@link net.zffu.hardened.api.commands.Command} call. Allows for multiplatform.
 * @since 1.0.0
 */
public interface CommandInvoker {

    /**
     * Gets the {@link InvokerType} of the {@link CommandInvoker}.
     * @return the {@link InvokerType}
     */
    @NotNull InvokerType getType();

    /**
     * Determines if the {@link CommandInvoker} has the provided permission.
     * @param permission the permission identifier
     * @return
     */
    boolean hasPermission(@NotNull String permission);

}
