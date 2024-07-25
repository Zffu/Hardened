package net.zffu.hardened.api.commands.validator.nodes.impl;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.context.CommandContext;

/**
 * A {@link ValidatorNode} that can be disabled or enabled. If disabled the command will not be executed!
 * @since 1.0.0
 */
public class DisabledNode implements ValidatorNode<Command> {

    private boolean disabled;

    public DisabledNode(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean validate(Command command, CommandContext ctx) {
        return !disabled;
    }
}
