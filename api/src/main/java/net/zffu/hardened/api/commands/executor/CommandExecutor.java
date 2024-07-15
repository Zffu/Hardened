package net.zffu.hardened.api.commands.executor;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.invoker.CommandInvoker;

/**
 * An executor of a {@link Command}. Basically does the command logic part.
 * @since 0.0.1
 * @see {@link Command}.
 */
public interface CommandExecutor {

    /**
     * Executes the logic from the {@link CommandExecutor} based on the {@link CommandInvoker}.
     * @param invoker the {@link CommandInvoker}
     */
    void execute(CommandInvoker invoker);

}
