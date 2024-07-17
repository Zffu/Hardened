package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.types.ArgCommand;
import net.zffu.hardened.api.commands.types.DisabledCommand;
import net.zffu.hardened.api.commands.types.PermissionCommand;
import net.zffu.hardened.api.commands.types.TypeGatedCommand;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 1.0.0
 * @see {@link Command}
 */
public abstract class BuilderCommand implements Command<BuilderCommandValidator>, TypeGatedCommand, ArgCommand, PermissionCommand, DisabledCommand {

    private static BuilderCommandValidator validator = new BuilderCommandValidator();

    protected InvokerType[] allowedTypes;

    protected String[] names;

    protected Argument[] arguments;

    protected String permission;

    protected boolean disabled;

    @Override
    public String[] getNames() {
        return this.names;
    }

    @Override
    public BuilderCommandValidator getValidator() {
        return validator;
    }

    @Override
    public InvokerType[] getAllowedInvokers() {
        return this.allowedTypes;
    }

    @Override
    public Argument[] getArguments() {
        return this.arguments;
    }

    @Override
    public String getRequiredPermission() {
        return this.permission;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }
}
