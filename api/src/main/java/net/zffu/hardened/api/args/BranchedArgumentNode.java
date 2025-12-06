package net.zffu.hardened.api.args;

import net.zffu.hardened.api.command.CommandContext;
import net.zffu.hardened.api.command.CommandTreeTraversable;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class BranchedArgumentNode implements CommandTreeTraversable {

    public final ArgumentType type;
    public final String name;

    private HashMap<Object, CommandTreeTraversable> branches;

    public BranchedArgumentNode(String name, ArgumentType type) {
        this.name = name;
        this.type = type;
        this.branches = new HashMap<>();
    }

    /**
     * Appends a branch to the argument node.
     * @param val the branch value.
     * @param node the node.
     * @return the same instance
     */
    public BranchedArgumentNode branch(Object val, CommandTreeTraversable node) {
        this.branches.put(val, node);

        return this;
    }

    @Override
    public boolean traverse(CommandContext ctx) {
        Object o = this.type.parse(ctx.getCurrentArgument());
        if(o == null) return false;

        ctx.appendArgument(this.name, o);

        CommandTreeTraversable treeTraversable = this.branches.get(o);
        if(treeTraversable == null) return false;

        ctx.incrementArgumentCount();
        return treeTraversable.traverse(ctx);
    }

    @Override
    public @Nullable CommandTreeTraversable getNext(CommandContext ctx) {
        Object o = this.type.parse(ctx.getCurrentArgument());
        if(o == null) return null;

        return this.branches.get(o);
    }
}
