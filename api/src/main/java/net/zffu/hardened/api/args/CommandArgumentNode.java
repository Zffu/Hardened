package net.zffu.hardened.api.args;

import net.zffu.hardened.api.command.CommandTreeTraversable;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an argument inside a command tree.
 * <b>This argument doesn't have choices and is just a basic argument.</b>
 * @param <K> the datatype
 */
public class CommandArgumentNode<K> implements CommandTreeTraversable {

    public final String name;

    public @NotNull CommandTreeTraversable nextNode;

    public CommandArgumentNode(String name) {
        this.name = name;
    }

    @Override
    public boolean traverse() {
        // TODO: Add argument parsing to this

        if (this.nextNode != null) return this.nextNode.traverse();
        return true;
    }
}
