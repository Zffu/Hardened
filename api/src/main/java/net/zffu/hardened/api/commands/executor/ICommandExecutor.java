package net.zffu.hardened.api.commands.executor;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.invoker.ICommandInvoker;

/**
 * An executor of a {@link Command}. Basically does the command logic part.
 * @since 0.0.1
 * @see {@link Command}.
 */
public interface ICommandExecutor {

    /**
     * Executes the logic from the {@link ICommandExecutor} based on the {@link ICommandInvoker}.
     * @param invoker the {@link ICommandInvoker}
     */
    void execute(ICommandInvoker invoker);

}
