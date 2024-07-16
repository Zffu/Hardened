package net.zffu.hardened.api.tests;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.ArgumentTypes;
import net.zffu.hardened.api.commands.builder.CommandBuilder;
import net.zffu.hardened.api.context.CommandContext;

public class ArgumentFormattingTest {

    public static void main(String[] args) {
        CommandBuilder command = new CommandBuilder() {
            @Override
            public void execute(CommandContext commandContext) {

            }
        };
        command.args(new Argument(ArgumentTypes.STRING.get()));

        CommandContext ctx = CommandContext.preFormatArguments(null, command, "test", new String[]{"test"});

        ctx.get(0, String.class); // Shouldn't fail
        ctx.get(0,Integer.class); // Should fail
    }

}
