package net.zffu.hardened.api.args;

import net.zffu.hardened.api.command.CommandTreeTraversable;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an argument inside a command tree.
 * <b>This argument doesn't have choices and is just a basic argument.</b>
 */
public class CommandArgumentNode implements CommandTreeTraversable {

    public final ArgumentType type;
    public final String name;

    public @Nullable CommandTreeTraversable nextNode;

    public CommandArgumentNode(String name, ArgumentType type) {
        this.name = name;
        this.type = type;
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

}
