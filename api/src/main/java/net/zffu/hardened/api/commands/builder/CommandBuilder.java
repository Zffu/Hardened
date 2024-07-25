package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.CommandExecution;
import net.zffu.hardened.api.commands.validator.nodes.NodeCommandValidator;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.commands.validator.nodes.impl.DisabledNode;
import net.zffu.hardened.api.commands.validator.nodes.impl.PermissionNode;
import net.zffu.hardened.api.commands.validator.nodes.impl.TypeGatedNode;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * <p>Simple way to create commands in Hardened.</p>
 * @since 1.0.0
 * @see {@link net.zffu.hardened.api.commands.Command}
 */
public class CommandBuilder {

    private BuilderCommand command;

    public CommandBuilder(String primaryName) {
        this.command = new BuilderCommand(primaryName);
    }

    /**
     * Sets the aliases of the command.
     * @param aliases
     * @return
     */
    public CommandBuilder aliases(String... aliases) {
        this.command.aliases = aliases;
        return this;
    }

    /**
     * Adds a {@link ValidatorNode} into the builder's {@link NodeCommandValidator}.
     * @param node the {@link ValidatorNode} to add.
     * @return
     */
    public CommandBuilder node(ValidatorNode node) {
        this.command.validator.getNodes().add(node);
        return this;
    }

    /**
     * Adds a permission that is required to have before running the command.
     * @param permission the permission.
     * @return
     */
    public CommandBuilder permission(String permission) {
        return this.node(new PermissionNode(permission));
    }

    /**
     * Adds types that the {@link net.zffu.hardened.api.invoker.CommandInvoker} must be in order to run the command.
     * @param types an {@link InvokerType} array.
     * @return
     */
    public CommandBuilder type(InvokerType... types) {
        return this.node(new TypeGatedNode(types));
    }

    /**
     * Adds a node that is disabled or not.
     * @param disabled
     * @return
     */
    public CommandBuilder disabled(boolean disabled) {
        return this.node(new DisabledNode(disabled));
    }

    /**
     * Adds an {@link Argument} inside the command.
     * @param argument
     * @return
     */
    public CommandBuilder argument(Argument argument) {
        this.command.arguments.add(argument);
        return this;
    }

    /**
     * Sets the command's execution logic.
     * @param execution the logic as a {@link CommandExecution}
     * @return
     */
    public CommandBuilder execute(CommandExecution execution) {
        this.command.execution = execution;
        return this;
    }

    /**
     * Builds out the {@link net.zffu.hardened.api.commands.Command}.
     * @return the built command as a {@link BuilderCommand}
     */
    public BuilderCommand build() {
        return this.command;
    }

}
