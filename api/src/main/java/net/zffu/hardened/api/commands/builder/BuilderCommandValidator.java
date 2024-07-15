package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.invoker.CommandInvoker;

import java.util.Arrays;

/**
 * An implementation of a {@link CommandValidator} for the {@link BuilderCommand}
 * @since 0.0.1
 * @see {@link BuilderCommand}
 */
public class BuilderCommandValidator implements CommandValidator<BuilderCommand> {

    @Override
    public boolean validate(BuilderCommand command, CommandInvoker invoker) {
        //todo: optimize this logic to not have to use Arrays.asList
        if(command.allowedTypes == null || Arrays.asList(command.allowedTypes).contains(invoker.getType())) return true;
        return false;
    }
}
