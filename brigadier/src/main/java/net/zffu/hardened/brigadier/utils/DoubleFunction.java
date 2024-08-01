package net.zffu.hardened.brigadier.utils;

@FunctionalInterface
public interface DoubleFunction<T, E, R> {

    R get(T t, E e);

}
