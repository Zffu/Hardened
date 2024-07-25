package net.zffu.hardened.api.commands;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * <p>The base of every command registered trough the Hardened API. Any command that uses this API should implement this.</p>
 * <p>An interface that stores basic command metadata, the {@link CommandValidator} and the execution function.</p>
 * @param <T> the class of the {@link CommandValidator} for that command.
 * @since 1.0.0
 */
public interface Command<T extends CommandValidator> extends CommandExecution {

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
     * <p>Gets the arguments that the command contains. Used in argument parsing</p>
     * <p><b>Note:</b> No checks for required arguments are done by default, you should use a validator node for that.</p>
     * @return the command arguments as an {@link Argument[]}
     */
    @NotNull List<Argument> getArguments();

    /**
     * <p>Gets the command validator. The command validator is used to validate that a specific context can run the command.</p>
     * @return the {@link CommandValidator}
     */
    @Nullable T getValidator();

    /**
     * <p>Performs validator checks and executes the command logic using the provided context if the validator allows the context to run the command.</p>
     * @param commandContext the {@link CommandContext} provided.
     */
    default void run(@NotNull CommandContext commandContext) {
        if(getValidator() == null || getValidator().validate(this, commandContext)) execute(commandContext);
    }

}
