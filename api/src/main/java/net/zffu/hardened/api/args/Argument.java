package net.zffu.hardened.api.args;

import org.jetbrains.annotations.NotNull;

/**
 * An argument of a {@link net.zffu.hardened.api.commands.Command}.
 * @since 1.0.0
 */
public class Argument {

    private ArgumentType<?> type;
    private boolean optional;

    /**
     * Constructs a new {@link Argument}.
     *
     * @param type
     */
    public Argument(@NotNull ArgumentType<?> type) {
        this.type = type;
    }

    /**
     * Sets if the {@link Argument} is optional or not.
     *
     * @param isOptional is the {@link Argument} optional.
     * @return
     */
    public Argument optional(boolean isOptional) {
        this.optional = isOptional;
        return this;
    }

    /**
     * Gets the {@link ArgumentType} of the {@link Argument}
     * @return
     */
    public @NotNull ArgumentType<?> getType() {
        return this.type;
    }

    /**
     * Returns if the {@link Argument} is optional or not.
     * @return
     */
    public boolean isOptional() {
        return this.optional;
    }
}
