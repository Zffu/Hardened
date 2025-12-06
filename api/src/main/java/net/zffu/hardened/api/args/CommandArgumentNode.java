package net.zffu.hardened.api.args;

import net.zffu.hardened.api.command.CommandTreeTraversable;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an argument inside a command tree.
 * <b>This argument doesn't have choices and is just a basic argument.</b>
 * @param <K> the datatype
 */
public class CommandArgumentNode<K> implements CommandTreeTraversable {

    public final String name;

    public @Nullable CommandTreeTraversable nextNode;

    public CommandArgumentNode(String name) {
        this.name = name;
    }

    @Override
    public boolean traverse() {
        // TODO: Add argument parsing to this

        if (this.nextNode != null) return this.nextNode.traverse();
        return true;
    }

    @Override
    public @Nullable CommandTreeTraversable getNext() {
        return this.nextNode;
    }

    @Override
    public void appendToLeaf(CommandTreeTraversable node) {
        if(this.nextNode == null) {
            this.nextNode = node;
            return;
        }

        CommandTreeTraversable n = this;
        CommandTreeTraversable next = n.getNext();

        while(next != null) {
            n = next;
            next = n.getNext();
        }

        n.appendToLeaf(node);
    }
}
