package net.zffu.hardened.api.args;

/**
 * An argument of a {@link net.zffu.hardened.api.commands.Command}.
 * @since 0.0.1
 */
public class Argument {

    private ArgumentType<?> type;

    /**
     * Constructs a new {@link Argument}.
     * @param type
     */
    public Argument(ArgumentType<?> type) {
        this.type = type;
    }

}
