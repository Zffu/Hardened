package net.zffu.hardened.api.invoker;

/**
 * <p>A factory to create command invokers.</p>
 * @param <S> the type of invoker to create
 * @param <T> the type of the "command sender" of the invoker
 */
public interface InvokerFactory<S extends CommandInvoker<T>, T> {

    /**
     * <p>Creates an {@link CommandInvoker} of type S for the provided sender with the provided type.</p>
     * @param sender the sender.
     * @param type the type.
     * @return the {@link CommandInvoker} as S.
     */
    S createInvoker(T sender, InvokerType type);

}
