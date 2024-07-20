package net.zffu.hardened.paper.utils;

/**
 * <p>Custom {@link java.util.function.Function} implementation allowing for two arguments.</p>
 * @param <R> the return type.
 * @param <T> the first argument's type.
 * @param <V> the second argument's type.
 * @since 1.0.0
 * @author Zffu
 */
@FunctionalInterface
public interface DoubleFunction<R, T, V> {

    /**
     * <p>Applies the two arguments to the function.</p>
     * @param t the first argument.
     * @param v the second argument.
     * @return the return object.
     */
    R apply(T t, V v);

}
