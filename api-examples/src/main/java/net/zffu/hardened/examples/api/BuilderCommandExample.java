package net.zffu.hardened.examples.api;

import com.sun.org.apache.xpath.internal.Arg;
import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.Arguments;
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
                .argument(Arguments.string().min(3).max(16))
                .execute((ctx) -> System.out.println("Hello " + ctx.get(0,String.class))) // Sets the command actions
                .build(); // Builds out the command
    }

}
