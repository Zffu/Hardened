package net.zffu.hardened.api.args;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * A type of argument
 * @param <S>
 *
 * @since 1.0.0
 */
public interface ArgumentType<S> {

    /**
     * Parses the argument string into the datatype.
     * @param argumentStr the argument string
     * @return the argument as S
     */
    S parse(String argumentStr);

    /**
     * Get the possible argument choices for autocompletion (if enabled)
     * @return a collection with the choices if it is a non-classic datatype or null if it is
     */
    @Nullable Collection<String> getChoices();

}
