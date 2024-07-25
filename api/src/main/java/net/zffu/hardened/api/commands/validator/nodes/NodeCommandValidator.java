package net.zffu.hardened.api.commands.validator.nodes;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link CommandValidator} that uses the node command validation approach.
 * @since 1.0.0
 */
public class NodeCommandValidator<T extends Command> implements CommandValidator<T> {

    private ValidatorNode<T>[] nodes;

    public NodeCommandValidator(ValidatorNode<T>... nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean validate(@NotNull T command, @NotNull CommandContext context) {
        for(ValidatorNode<T> node : this.nodes) {
            if(!node.validate(command, context)) return false;
        }
        return true;
    }

}
