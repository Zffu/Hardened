package net.zffu.hardened.api.commands;

import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Contains the execute function of a {@link Command}.</p>
 * @since 1.0.0
 * @see {@link Command}
 */
@FunctionalInterface
public interface CommandExecution {

    /**
     * <p>Triggers the command logic based on the provided context without doing any validation beforehand.</p>
     * <p><b>Note: </b>The run function should be used as it has validator checks.</p>
     * @param commandContext the {@link CommandContext} provided to the logic.
     */
    void execute(@NotNull CommandContext commandContext);

}
