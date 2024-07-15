package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

public class CommandBuilderTest {

    public static void main(String[] args) {
        SimpleInvoker playerInvoker = new SimpleInvoker(InvokerType.PLAYER); // Should work with the command.
        SimpleInvoker consoleInvoker = new SimpleInvoker(InvokerType.CONSOLE); // Should not work with the command.

        Command command = new CommandBuilder("test") {
            @Override
            public void execute(CommandContext commandContext) {
                System.out.println("Hello " + commandContext.getInvoker().getType().name() + " from " + commandContext.getName());
            }
        }.allowed(InvokerType.PLAYER);

        // Validator Tests

        if(!command.getValidator().validate(command, playerInvoker)) throw new IllegalStateException("Player Invoker should be allowed to use the command");
        if(command.getValidator().validate(command, consoleInvoker)) throw new IllegalStateException("Console Invoker shouldn't be allowed to use the command");

        // Execution test


        System.out.println("All tests were successful!");
    }

}
