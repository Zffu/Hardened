package net.zffu.hardened.examples.api;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * An example on how to use the {@link net.zffu.hardened.api.commands.builder.CommandBuilder}
 */
public class BuilderCommandExample {

    public static void main(String[] args) {
        Command command = new CommandBuilder("test") // Creates a command with the primary name test
                .type(InvokerType.PLAYER) // Only allows players to run the command
                .permission("test.permission") // Makes the player need the permission "test.permission" in order to run the command.
                .execute((ctx) -> System.out.println("Hello " + ctx.getInvoker().getType())) // Sets the command actions
                .build(); // Builds out the command
    }

}
