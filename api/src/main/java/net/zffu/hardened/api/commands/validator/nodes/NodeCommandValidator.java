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

    @Override
    public boolean validate(@NotNull Command command, @NotNull CommandContext context) {
        return false;
    }

}
