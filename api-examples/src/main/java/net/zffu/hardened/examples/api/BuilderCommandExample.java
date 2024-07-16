package net.zffu.hardened.examples.api;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.ArgumentTypes;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * An example on how to use the {@link net.zffu.hardened.api.commands.builder.CommandBuilder}
 */
public class BuilderCommandExample {

    public static void main(String[] args) {

        // Creates the base of the command builder
        CommandBuilder builder = new CommandBuilder() {

            // Everything in that function will be ran after validation.
            @Override
            public void execute(CommandContext commandContext) {
                String name = commandContext.get(0, String.class); // Gets the first argument of the command.
                System.out.println("Hello " + name);
            }

        }
        // Adds properties to the CommandBuilder.
        .allowed(InvokerType.PLAYER) // Makes sure only players can run this command
        .args(new Argument(ArgumentTypes.STRING.get())); // Adds a string argument
    }

}
