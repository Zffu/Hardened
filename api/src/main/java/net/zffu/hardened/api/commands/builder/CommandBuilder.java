package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 1.0.0
 * @see {@link Command}
 */
public class CommandBuilder extends BuilderCommand {

    private Consumer<CommandContext> executeFunction;

    /**
     * Constructs a new {@link CommandBuilder}.
     * @param primaryName the command name.
     */
    public CommandBuilder(String primaryName) {
        this.primaryName = primaryName;
    }

    /**
     * Constructs a new {@link CommandBuilder}.
     * @param primaryName the command name.
     * @param aliases the aliases.
     */
    public CommandBuilder(String primaryName, String... aliases) {
        this.primaryName = primaryName;
        this.aliases = aliases;
    }

    /**
     * Sets the {@link InvokerType} that are allowed to run the command.
     * @param types
     * @return
     */
    public CommandBuilder allowed(InvokerType... types) {
        this.allowedTypes = Arrays.asList(types);
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
    public CommandBuilder runAction(Consumer<CommandContext> func) {
        this.executeFunction = func;
        return this;
    }

    /**
     * Gets the permission required to run the command.
     * @param permission the permission.
     * @return
     */
    public CommandBuilder permission(String permission) {
        this.permission = permission;
        return this;
    }

    /**
     * Should the command be disabled or not.
     * @param isDisabled
     * @return
     */
    public CommandBuilder disabled(boolean isDisabled) {
        this.disabled = isDisabled;
        return this;
    }

    @Override
    public void execute(CommandContext commandContext) {
        if(executeFunction != null) executeFunction.accept(commandContext);
    }
}
