package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.impl.LengthArgument;
import net.zffu.hardened.api.args.impl.RangedArgument;
import net.zffu.hardened.api.args.types.*;
import sun.security.util.Length;

import java.util.Arrays;

/**
 * Useful class to generate {@link Argument} instances faster.
 * @since 1.0.0
 * @see {@link Argument}
 */
public class Arguments {

    private static final IntegerArgument INT = new IntegerArgument();
    private static final DoubleArgument DOUBLE = new DoubleArgument();
    private static final FloatArgument FLOAT = new FloatArgument();
    private static final StringArgument STRING = new StringArgument();


    /**
     * Gets a simple integer argument.
     * @return
     */
    public static RangedArgument integer() {
        return new RangedArgument(INT);
    }

    /**
     * Gets a simple double argument.
     * @return
     */
    public static RangedArgument double_() {
        return new RangedArgument(DOUBLE);
    }

    /**
     * Gets a simple float argument.
     * @return
     */
    public static RangedArgument float_() {
        return new RangedArgument(FLOAT);
    }

    /**
     * Gets a simple list argument.
     * @return
     */
    public static Argument list(String... choices) {
        return new Argument(new ListArgument(Arrays.asList(choices)));
    }


    /**
     * Gets a simple string argument.
     * @return
     */
    public static LengthArgument string() {
        return new LengthArgument(STRING);
    }
}
