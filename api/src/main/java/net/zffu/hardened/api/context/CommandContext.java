package net.zffu.hardened.api.context;

import net.zffu.hardened.api.invoker.CommandInvoker;

/**
 * The context of a {@link net.zffu.hardened.api.commands.Command} execution.
 * @since 0.0.1
 * @see {@link CommandInvoker}
 */
public interface CommandContext {

    /**
     * Gets the {@link CommandInvoker} from the {@link CommandContext}.
     * @return
     */
    CommandInvoker getInvoker();

    /**
     * Gets the args from the {@link CommandContext}.
     * @return the args
     */
    String[] getArgs();

    /**
     * Gets the name used when running the command.
     * @return
     */
    String getName();

}
