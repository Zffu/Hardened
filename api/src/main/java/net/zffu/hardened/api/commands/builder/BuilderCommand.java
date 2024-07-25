package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.commands.validator.nodes.NodeCommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BuilderCommand implements Command {

    private String primaryName;
    private String[] aliases;
    private NodeCommandValidator<BuilderCommand> validator;

    @Override
    public @NotNull String getPrimaryName() {
        return this.primaryName;
    }

    @Override
    public @NotNull String[] getAliases() {
        return this.aliases;
    }

    @Nullable
    @Override
    public CommandValidator getValidator() {
        return this.validator;
    }

    @Override
    public void execute(@NotNull CommandContext commandContext) {

    }
}
