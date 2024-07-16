package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

import java.util.function.Function;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 0.0.1
 * @see {@link Command}
 */
public class CommandBuilder extends BuilderCommand {

    private Function<CommandContext, ?> executeFunction;

    /**
     * Constructs a new {@link CommandBuilder}.
     * @param names the command names.
     */
    public CommandBuilder(String... names) {
        this.names = names;
    }

    /**
     * Sets the {@link InvokerType} that are allowed to run the command.
     * @param types
     * @return
     */
    public CommandBuilder allowed(InvokerType... types) {
        this.allowedTypes = types;
        return this;
    }

    /**
     * Sets the {@link Argument} of the command.
     * @param args the args.
     * @return
     */
    public CommandBuilder args(Argument... args) {
        this.arguments = args;
        return this;
    }

    /**
     * Sets the executeFunction of the command.
     * @param func
     * @return
     */
    public CommandBuilder runAction(Function<CommandContext, ?> func) {
        this.executeFunction = func;
        return this;
    }

    @Override
    public void execute(CommandContext commandContext) {
        if(executeFunction != null) executeFunction.apply(commandContext);
    }
}
