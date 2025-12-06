package net.zffu.hardened.api.command;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    /**
     * Get the next node.
     * @return the node
     */
    @Nullable CommandTreeTraversable getNext();

}
