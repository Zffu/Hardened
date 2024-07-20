package net.zffu.hardened.api.commands;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The base of every command created trough the Hardened API.
 * @since 1.0.0
 */
public interface Command<T extends CommandValidator> {

    /**
     * Gets the primary name of the command.
     * @return
     */
    @NotNull String getPrimaryName();

    /**
     * Gets the aliases of the command.
     * @return
     */
    @NotNull String[] getAliases();

    /**
     * <p>Gets the {@link CommandValidator} for that {@link Command}.</p>
     * <p>The {@link CommandValidator} varies depending on the implementation of the {@link Command} class used.</p>
     * @return the {@link CommandValidator}.
     */
    @Nullable T getValidator();

    /**
     * Performs the {@link Command} logic with the provided {@link CommandInvoker}.
     * @param commandContext the {@link CommandInvoker}
     */
    void execute(@NotNull CommandContext commandContext);

    /**
     * Runs the {@link Command} and checks using the {@link CommandValidator}.
     * @param commandContext
     */
    default void run(@NotNull CommandContext commandContext) {
        if(getValidator() == null || getValidator().validate(this, commandContext)) execute(commandContext);
    }

}
