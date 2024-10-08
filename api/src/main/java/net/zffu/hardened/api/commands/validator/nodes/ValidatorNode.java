package net.zffu.hardened.api.commands.validator.nodes;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.context.CommandContext;

/**
 * A Validator / Validation node. Used in the node command validator.
 * @param <T>
 * @since 1.0.0
 * @see {@link NodeCommandValidator}
 */
@FunctionalInterface
public interface ValidatorNode {

    /**
     * Validates the command for the validator node.
     * @param command the {@link Command}
     * @param ctx the {@link CommandContext}
     * @return true or false.
     */
    boolean validate(Command command, CommandContext ctx);

}
