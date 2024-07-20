package net.zffu.hardened.examples.api;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.ArgumentTypes;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;

/**
 * An example on how to use the {@link net.zffu.hardened.api.commands.builder.CommandBuilder}
 */
public class BuilderCommandExample {

    public static void main(String[] args) {

        // Creates the base of the command builder
        CommandBuilder commandBuilder = new CommandBuilder("test").runAction((ctx) -> {
            System.out.println("Hello " + ctx.getInvoker().getType().name());
        })
        // Adds properties to the CommandBuilder.
        .allowed(InvokerType.PLAYER) // Makes sure only players can run this command
        .args(new Argument(ArgumentTypes.STRING)); // Adds a string argument
    }

}
