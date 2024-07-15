package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.invoker.InvokerType;

public class CommandBuilderTest {

    public static void main(String[] args) {
        SimpleInvoker playerInvoker = new SimpleInvoker(InvokerType.PLAYER); // Should work with the command.
        SimpleInvoker consoleInvoker = new SimpleInvoker(InvokerType.CONSOLE); // Should not work with the command.

        Command command = new CommandBuilder("test").allowed(InvokerType.PLAYER);

        // Validator Tests

        if(!command.getValidator().validate(command, playerInvoker)) throw new IllegalStateException("Player Invoker should be allowed to use the command");
        if(command.getValidator().validate(command, consoleInvoker)) throw new IllegalStateException("Console Invoker shouldn't be allowed to use the command");

        System.out.println("All tests were successful!");
    }

}
