package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

public class CommandBuilderTest {

    public static void main(String[] args) {
        CommandContext playerContext = new CommandContext(new SimpleInvoker(InvokerType.PLAYER), null, ""); // Should work with the command.
        CommandContext consoleContext = new CommandContext(new SimpleInvoker(InvokerType.CONSOLE), null, ""); // Should not work with the command.

        Command command = new CommandBuilder("test") {
            @Override
            public void execute(CommandContext commandContext) {
                System.out.println("Hello " + commandContext.getInvoker().getType().name() + " from " + commandContext.getName());
            }
        }.allowed(InvokerType.PLAYER);

        // Validator Tests

        if(!command.getValidator().validate(command, playerContext)) throw new IllegalStateException("Player Invoker should be allowed to use the command");
        if(command.getValidator().validate(command, consoleContext)) throw new IllegalStateException("Console Invoker shouldn't be allowed to use the command");

        // Execution test
        command.run(playerContext);

        System.out.println("All tests were successful!");
    }

}
