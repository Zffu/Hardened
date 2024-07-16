package net.zffu.hardened.api.args;

/**
 * An argument of a {@link net.zffu.hardened.api.commands.Command}.
 * @since 0.0.1
 */
public class Argument {

    private ArgumentType<?> type;
    private boolean optional;

    /**
     * Constructs a new {@link Argument}.
     * @param type
     */
    public Argument(ArgumentType<?> type) {
        this.type = type;
    }

    /**
     * Sets if the {@link Argument} is optional or not.
     * @param isOptional is the {@link Argument} optional.
     * @return
     */
    public Argument optional(boolean isOptional) {
        this.optional = isOptional;
        return this;
    }

}
