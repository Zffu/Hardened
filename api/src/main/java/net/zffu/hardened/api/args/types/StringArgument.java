package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;

/**
 * A string {@link ArgumentType}.
 * @since 1.0.0
 */
public class StringArgument implements ArgumentType<String> {

    @Override
    public String fromString(String s) {
        return s;
    }
}
