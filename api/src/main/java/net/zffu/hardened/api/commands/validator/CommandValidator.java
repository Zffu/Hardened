package net.zffu.hardened.api.commands.validator;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A command validator is a piece of code that will make sure that a specific {@link CommandContext} can run the command.</p>
 * <p>Using validators allows for a cleaner and more replicative way than using raw conditions in the command logic like in Spigot.</p>
 * <p>A validator can be used on multiple {@link Command} implementations.</p>
 * @param <T> the command type that the validator will validate.
 * @since 1.0.0
 */
public interface CommandValidator<T extends Command > {

    /**
     * <p>Performs validations on the provided command context for the provided command instance.</p>
     * @param command the {@link Command}
     * @param invoker the {@link CommandContext}
     * @return true or false
     */
    boolean validate(@NotNull T command, @NotNull CommandContext invoker);

}
