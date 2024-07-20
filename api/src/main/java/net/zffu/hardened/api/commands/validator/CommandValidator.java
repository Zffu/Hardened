package net.zffu.hardened.api.commands.validator;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Validates that a {@link Command} can be ran by the provided {@link CommandInvoker}.</p>
 * @since 1.0.0
 */
public interface CommandValidator<T extends Command > {

    /**
     * Validates the {@link CommandInvoker} for a {@link Command}
     * @param command the {@link Command} to validate for.
     * @param invoker the invoker.
     * @return true if the invoker is allowed to run the command or else false
     */
    boolean validate(@NotNull T command, @NotNull CommandContext invoker);

}
