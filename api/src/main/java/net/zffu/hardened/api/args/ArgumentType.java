package net.zffu.hardened.api.args;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A type of argument values that is used in {@link net.zffu.hardened.api.commands.Command}
 @since 1.0.0
 */
public interface ArgumentType<T> {

    /**
     * Converts the String into a {@link ArgumentType} value.
     * @param s the string.
     * @return the value.
     */
    @Nullable T fromString(@NotNull String s);

}



