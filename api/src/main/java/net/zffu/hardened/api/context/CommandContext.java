package net.zffu.hardened.api.context;

import net.zffu.hardened.api.args.ArgumentType;
import net.zffu.hardened.api.invoker.CommandInvoker;

/**
 * The context of a {@link net.zffu.hardened.api.commands.Command} execution.
 * @since 0.0.1
 * @see {@link CommandInvoker}
 */
public class CommandContext {

    private CommandInvoker invoker;
    private Object[] args; // Preformatted args
    private String name;

    /**
     * <p>Constructs a new {@link CommandContext}.</p>
     * @param invoker the {@link CommandInvoker}
     * @param args the preformatted args
     * @param name the name
     */
    public CommandContext(CommandInvoker invoker, Object[] args, String name) {
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
     * Gets the arg from the {@link CommandContext} based on the {@link ArgumentType}.
     * @return
     */
    public <T> T get(int index, Class<T> clazz) {
        Object o = this.args[index];

        if(clazz.isAssignableFrom(o.getClass())) {
            return (T) o;
        }
        throw new IllegalArgumentException("Tried getting the argument with index " + index + " with the " + clazz.getName() + " but argument value isn't of the same type!");
    }

    /**
     * Gets the name of the command used in the {@link CommandContext}.
     * @return
     */
    public String getName() {
        return this.name;
    }
}
