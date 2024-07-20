package net.zffu.hardened.api.args;

import org.jetbrains.annotations.NotNull;

/**
 * <p>A command argument in the Hardened API.</p>
 * @since 1.0.0
 * @see {@link ArgumentType}
 */
public class Argument {

    private ArgumentTypes type;
    private boolean optional;

    /**
     * <p>Creates a new {@link Argument}.</p>
     * @param type
     */
    public Argument(@NotNull ArgumentTypes type) {
        this.type = type;
    }

    /**
     * <p>Sets if the {@link Argument} is optional or not.</p>
     * @param isOptional is the {@link Argument} optional.
     */
    public Argument optional(boolean isOptional) {
        this.optional = isOptional;
        return this;
    }

    /**
     * <p>Gets the type of the argument.</p>
     * @return the {@link ArgumentTypes}
     */
    public @NotNull ArgumentTypes getType() {
        return this.type;
    }

    /**
     * <p>Returns if the {@link Argument} is optional or not.</p>
     * @return
     */
    public boolean isOptional() {
        return this.optional;
    }
}
