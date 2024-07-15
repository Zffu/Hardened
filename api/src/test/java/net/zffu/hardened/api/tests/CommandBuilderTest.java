package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;

public class CommandBuilderTest {

    public static void main(String[] args) {

        // Invokers shouldn't be made like that its just for testing purposes.
        CommandInvoker sampleInvoker = new CommandInvoker() {
            @Override
            public InvokerType getType() {
                return InvokerType.PLAYER;
            }
        };

        CommandBuilder builder = new CommandBuilder("test");
        builder.allowed(InvokerType.PLAYER); // Only allows player to run the test command

        System.out.println("Validation Result: " + builder.getValidator().validate(builder, sampleInvoker));
    }

}
