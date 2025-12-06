package net.zffu.hardened.api;

import org.jetbrains.annotations.Nullable;

/**
 * <p>The base of the Hardened API.</p>
 * @since 1.0.0
 */
public class Hardened {

    /**
     * <p>The core instance of the Hardened API. Is modified by platforms</p>
     */
    private static Hardened instance;


    /**
     * <p>Gets the current {@link Hardened} instance.</p>
     * @return the instance or null if it's not initialized yet.
     */
    public static @Nullable Hardened getInstance() {
        return instance;
    }

}
