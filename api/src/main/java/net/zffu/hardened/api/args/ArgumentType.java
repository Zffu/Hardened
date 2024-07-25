package net.zffu.hardened.api.args;

import net.zffu.hardened.api.commands.Command;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>A type of a command argument in the Hardened API.</p>
 * @param <T>
 * @since 1.0.0
 * @see {@link Command}
 */
public interface ArgumentType<T> {

    /**
     * <p>Parses the raw string argument into an argument value corresponding to the argument type.</p>
     * @param s
     * @return
     */
    @Nullable T fromString(@NotNull String s);

    /**
     * Can the raw string be parsed into that {@link ArgumentType}.
     * @param s the raw string.
     * @return true or false.
     */
    boolean canParse(@NotNull String s);

}



