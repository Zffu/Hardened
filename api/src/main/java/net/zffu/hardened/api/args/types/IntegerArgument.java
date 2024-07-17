package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;

/**
 * An Integer {@link ArgumentType}.
 * @since 1.0.0
 */
public class IntegerArgument implements ArgumentType<Integer> {

    @Override
    public Integer fromString(String s) {
        return Integer.valueOf(s);
    }
}
