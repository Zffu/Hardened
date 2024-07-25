package net.zffu.hardened.api.commands.validator.nodes.impl;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.nodes.ValidatorNode;
import net.zffu.hardened.api.context.CommandContext;

/**
 * A {@link ValidatorNode} that ensures that the command has enough arguments.
 */
public class ArgumentLengthNode implements ValidatorNode {

    @Override
    public boolean validate(Command command, CommandContext ctx) {
        if(ctx.getArgsLength() < command.getArguments().getRequiredCount()) return false;
        return true;
    }
}
