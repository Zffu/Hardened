package net.zffu.hardened.examples.api;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;

import java.util.Arrays;

/**
 * Example on how to make your own custom {@link net.zffu.hardened.api.commands.validator.CommandValidator}.
 * @see {@link CustomCommandExample}
 */
public class CustomCommandValidator implements CommandValidator<CustomCommandExample> {

    public static CustomCommandValidator instance = new CustomCommandValidator();

    @Override
    public boolean validate(CustomCommandExample command, CommandContext invoker) {
        if(Arrays.asList(command.getAllowedInvokers()).contains(invoker.getInvoker().getType())) return true; // Could simplify that but its for the sake of the example
        return false;
    }

}
