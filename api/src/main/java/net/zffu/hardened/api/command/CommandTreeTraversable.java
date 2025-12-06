package net.zffu.hardened.api.command;

/**
 * <p>A traversable node inside a command tree.</p>
 * @since 1.0.0
 */
public interface CommandTreeTraversable {

    /**
     * Traverses the node
     *
     * @return true if command was okay, false if not
     */
    //TODO: add command ctx
    boolean traverse();

}
