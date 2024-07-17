package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;

import java.util.Arrays;

/**
 * An implementation of a {@link CommandValidator} for the {@link BuilderCommand}
 * @since 0.0.1
 * @see {@link BuilderCommand}
 */
public class BuilderCommandValidator implements CommandValidator<BuilderCommand> {

    @Override
    public boolean validate(BuilderCommand command, CommandContext context) {
        if(command.disabled) return false;
        //todo: optimize this logic to not have to use Arrays.asList
        if(command.allowedTypes != null && !Arrays.asList(command.allowedTypes).contains(context.getInvoker().getType())) return false;
        if(command.permission != null && !context.getInvoker().hasPermission(command.permission)) return false;
        return true;
    }
}
