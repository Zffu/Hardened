package net.zffu.hardened.api.commands.validator.nodes.impl;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.context.CommandContext;

/**
 * A {@link ValidatorNode} that requires the Invoker to have a specific permission before running the command.
 * @since 1.0.0
 */
public class PermissionNode implements ValidatorNode<Command> {

    private String permission;

    public PermissionNode(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean validate(Command command, CommandContext ctx) {
        return (permission == null || ctx.getInvoker().hasPermission(permission));
    }
}
