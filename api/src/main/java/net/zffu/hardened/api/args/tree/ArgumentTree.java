package net.zffu.hardened.api.args.tree;

import net.zffu.hardened.api.args.Argument;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Stores the arguments of a {@link net.zffu.hardened.api.commands.Command}.</p>
 * @since 1.0.0
 * @see {@link net.zffu.hardened.api.args.Argument}
 */
public class ArgumentTree {

    private List<Argument> arguments;
    private int optional;

    public ArgumentTree() {
        this.arguments = new ArrayList<>();
        this.optional = 0;
    }

    /**
     * Adds an {@link Argument} into the tree.
     * @param argument
     */
    public void addArgument(Argument argument) {
        this.arguments.add(argument);
        if(argument.isOptional()) this.optional++;
    }

    /**
     * Gets the amount of optional arguments.
     * @return
     */
    public int getOptionalCount() {
        return this.optional;
    }

    /**
     * Gets the amount of required arguments.
     * @return
     */
    public int getRequiredCount() {
        return this.arguments.size() - this.optional;
    }

    public List<Argument> getArguments() {
        return this.arguments;
    }

}
