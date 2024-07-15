package net.zffu.hardened.api.commands.builder;

import javafx.util.Builder;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.types.TypeGatedCommand;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 0.0.1
 * @see {@link Command}
 */
public class BuilderCommand implements Command, TypeGatedCommand {

    protected InvokerType[] allowedTypes;
    protected String[] names;

    @Override
    public String[] getNames() {
        return this.names;
    }

    @Override
    public InvokerType[] getAllowedInvokers() {
        return this.allowedTypes;
    }

    /**
     * A {@link Validator} for the {@link BuilderCommand} class.
     */
    public class Validator implements CommandValidator<BuilderCommand> {

        @Override
        public boolean validate(BuilderCommand command, CommandInvoker invoker) {
            return false;
        }
    }
}
