package net.zffu.hardened.api.args;

import net.zffu.hardened.api.command.CommandContext;
import net.zffu.hardened.api.command.CommandTreeTraversable;
import org.jetbrains.annotations.NotNull;
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
    public boolean traverse(CommandContext ctx) {
        Object o = this.type.parse(ctx.getCurrentArgument());
        if(o == null) return false;

        ctx.appendArgument(this.name, o);

        if (this.nextNode != null) {
            ctx.incrementArgumentCount();

            return this.nextNode.traverse(ctx);
        }

        return true;
    }

    @Override
    public @Nullable CommandTreeTraversable getNext(CommandContext ctx) {
        return this.nextNode;
    }

}
