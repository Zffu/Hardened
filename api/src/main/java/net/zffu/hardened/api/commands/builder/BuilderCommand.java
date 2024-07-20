package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.types.ArgCommand;
import net.zffu.hardened.api.commands.types.DisabledCommand;
import net.zffu.hardened.api.commands.types.PermissionCommand;
import net.zffu.hardened.api.commands.types.TypeGatedCommand;
import net.zffu.hardened.api.invoker.InvokerType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 1.0.0
 * @see {@link Command}
 */
public abstract class BuilderCommand implements Command<BuilderCommandValidator>, TypeGatedCommand, ArgCommand, PermissionCommand, DisabledCommand {

    private static BuilderCommandValidator validator = new BuilderCommandValidator();

    protected String primaryName;

    protected List<InvokerType> allowedTypes;

    protected String[] aliases;

    protected Argument[] arguments;

    protected String permission;

    protected boolean disabled;

    @Override
    public String getPrimaryName() {
        return primaryName;
    }

    @Override
    public String[] getAliases() {
        return aliases;
    }

    @Override
    public BuilderCommandValidator getValidator() {
        return validator;
    }

    @Override
    public List<InvokerType> getAllowedInvokers() {
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
