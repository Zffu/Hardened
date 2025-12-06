package net.zffu.hardened.api.args;

/**
 * Represents an argument inside a command tree.
 * <b>This argument doesn't have choices and is just a basic argument.</b>
 * @param <K> the datatype
 */
public class CommandArgumentNode<K> {

    public final String name;

    public CommandArgumentNode(String name) {
        this.name = name;
    }

}
