package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.types.IntegerArgument;
import net.zffu.hardened.api.args.types.StringArgument;

/**
 * Useful class to generate {@link Argument} instances faster.
 * @since 1.0.0
 * @see {@link Argument}
 */
public class Arguments {

    // Default Argument Instances for caching.
    private static IntegerArgument DEFAULT_INT = new IntegerArgument();
    private static StringArgument DEFAULT_STRING = new StringArgument();

    /**
     * Gets a simple integer argument.
     * @return
     */
    public static IntegerArgument integer() {
        return DEFAULT_INT;
    }

    /**
     * Gets a simple string argument.
     * @return
     */
    public static StringArgument string() {
        return DEFAULT_STRING;
    }
}
