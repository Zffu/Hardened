package net.zffu.hardened.api.commands;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>The base of every command registered trough the Hardened API. Any command that uses this API should implement this.</p>
 * <p>An interface that stores basic command metadata, the {@link CommandValidator} and the execution function.</p>
 * @param <T> the class of the {@link CommandValidator} for that command.
 * @since 1.0.0
 */
public interface Command<T extends CommandValidator> {

    /**
     * <p>Gets the primary name of the command.</p>
     * <p>The primary name is the true name (not alias) of the command.</p>
     * @return the primary name of the command.
     */
    @NotNull String getPrimaryName();

    /**
     * <p>Gets the aliases of the command.</p>
     * @return the aliases of the command as a {@link String[]}
     */
    @NotNull String[] getAliases();

    /**
     * <p>Gets the command validator. The command validator is used to validate that a specific context can run the command.</p>
     * @return the {@link CommandValidator}
     */
    @Nullable T getValidator();

    /**
     * <p>Triggers the command logic based on the provided context without doing any validation beforehand.</p>
     * <p><b>Note: </b>The run function should be used as it has validator checks.</p>
     * @param commandContext the {@link CommandContext} provided to the logic.
     */
    void execute(@NotNull CommandContext commandContext);

    /**
     * <p>Performs validator checks and executes the command logic using the provided context if the validator allows the context to run the command.</p>
     * @param commandContext the {@link CommandContext} provided.
     */
    default void run(@NotNull CommandContext commandContext) {
        if(getValidator() == null || getValidator().validate(this, commandContext)) execute(commandContext);
    }

}
