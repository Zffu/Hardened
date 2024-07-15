package net.zffu.hardened.api.context;

import net.zffu.hardened.api.invoker.CommandInvoker;

/**
 * The context of a {@link net.zffu.hardened.api.commands.Command} execution.
 * @since 0.0.1
 * @see {@link CommandInvoker}
 */
public class CommandContext {

    private CommandInvoker invoker;
    private String[] args;
    private String name;

    /**
     * <p>Constructs a new {@link CommandContext}.</p>
     * @param invoker the {@link CommandInvoker}
     * @param args the args
     * @param name the name
     */
    public CommandContext(CommandInvoker invoker, String[] args, String name) {
        this.invoker = invoker;
        this.args = args;
        this.name = name;
    }

    /**
     * Gets the {@link CommandInvoker} of the {@link CommandContext}.
     * @return
     */
    public CommandInvoker getInvoker() {
        return this.invoker;
    }

    /**
     * Gets the ars from the {@link CommandContext}.
     * @return
     */
    public String[] getArgs() {
        return this.args;
    }

    /**
     * Gets the name of the command used in the {@link CommandContext}.
     * @return
     */
    public String getName() {
        return this.name;
    }
}
