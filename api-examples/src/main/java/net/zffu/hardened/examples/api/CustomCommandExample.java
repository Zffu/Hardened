package net.zffu.hardened.examples.api;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.types.TypeGatedCommand;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * An example on how to create your own {@link net.zffu.hardened.api.commands.Command} implementation with the custom features you want.
 */

// In this example we create a invoker gated command.
public class CustomCommandExample implements Command, TypeGatedCommand {

    private String[] names = new String[]{"test"};
    private InvokerType[] allowedInvokers = new InvokerType[] {InvokerType.PLAYER}; // Only allows players to use our command, this will not matter at all if the custom validator doesn't include a check for it

    @Override
    public String[] getNames() {
        return this.names;
    }

    @Override
    public CommandValidator getValidator() {
        return CustomCommandValidator.instance;
    }

    @Override
    public void execute(CommandContext commandContext) {
        System.out.println("Hello " + commandContext.getInvoker().getType().name());
    }

    @Override
    public InvokerType[] getAllowedInvokers() {
        return this.allowedInvokers;
    }
}
