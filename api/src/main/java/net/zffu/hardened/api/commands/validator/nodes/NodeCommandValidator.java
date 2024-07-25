package net.zffu.hardened.api.commands.validator.nodes;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link CommandValidator} that uses the node command validation approach.
 */
public class NodeCommandValidator implements CommandValidator<Command> {

    @Override
    public boolean validate(@NotNull Command command, @NotNull CommandContext context) {
        return false;
    }

}
