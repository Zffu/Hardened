package net.zffu.hardened.api.args;

/**
 * A type of argument values that is used in {@link net.zffu.hardened.api.commands.Command}
 @since 0.0.1
 */
public interface ArgumentType<T> {

    /**
     * Converts the String into a {@link ArgumentType} value.
     * @param s the string.
     * @return the value.
     */
    T fromString(String s);


}



