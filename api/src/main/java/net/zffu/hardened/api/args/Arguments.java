package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.types.IntegerArgument;
import net.zffu.hardened.api.args.types.StringArgument;

/**
 * Useful class to generate {@link Argument} instances faster.
 * @since 1.0.0
 * @see {@link Argument}
 */
public class Arguments {

    /**
     * Gets a simple integer argument.
     * @return
     */
    public static IntegerArgument integer() {
        return new IntegerArgument();
    }

    /**
     * Gets a simple string argument.
     * @return
     */
    public static StringArgument string() {
        return new StringArgument();
    }
}
