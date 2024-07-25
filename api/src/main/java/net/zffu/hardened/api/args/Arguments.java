package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.types.IntegerArgument;
import net.zffu.hardened.api.args.types.StringArgument;

/**
 * Useful class to generate {@link Argument} instances faster.
 * @since 1.0.0
 * @see {@link Argument}
 */
public class Arguments {

    private static final IntegerArgument INT = new IntegerArgument();
    private static final StringArgument STRING = new StringArgument();


    /**
     * Gets a simple integer argument.
     * @return
     */
    public static Argument integer() {
        return new Argument(INT);
    }

    /**
     * Gets a simple string argument.
     * @return
     */
    public static Argument string() {
        return new Argument(STRING);
    }
}
