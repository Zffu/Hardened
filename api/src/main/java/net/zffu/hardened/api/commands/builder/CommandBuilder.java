package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.validator.nodes.NodeCommandValidator;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.commands.validator.nodes.impl.PermissionNode;

/**
 * <p>Simple way to create commands in Hardened.</p>
 * @since 1.0.0
 * @see {@link net.zffu.hardened.api.commands.Command}
 */
public class CommandBuilder extends BuilderCommand {

    public CommandBuilder(String primaryName) {
        this.primaryName = primaryName;
    }

    /**
     * Sets the aliases of the command.
     * @param aliases
     * @return
     */
    public CommandBuilder aliases(String... aliases) {
        this.aliases = aliases;
        return this;
    }

    /**
     * Adds a {@link ValidatorNode} into the builder's {@link NodeCommandValidator}.
     * @param node the {@link ValidatorNode} to add.
     * @return
     */
    public CommandBuilder node(ValidatorNode node) {
        this.validator.getNodes().add(node);
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

}
