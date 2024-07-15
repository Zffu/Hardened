package net.zffu.hardened.api.args;

/**
 * A string {@link ArgumentType}.
 * @since 0.0.1
 */
public class StringArgument implements ArgumentType<String> {

    @Override
    public String fromString(String s) {
        return s;
    }
}
