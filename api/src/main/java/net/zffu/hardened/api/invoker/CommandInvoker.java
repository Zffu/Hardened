package net.zffu.hardened.api.invoker;

/**
 * The invoker of a {@link net.zffu.hardened.api.commands.Command} call. Allows for multiplatform.
 * @since 0.0.1
 */
public interface CommandInvoker {

    /**
     * Gets the {@link InvokerType} of the {@link CommandInvoker}.
     * @return the {@link InvokerType}
     */
    InvokerType getType();

}
