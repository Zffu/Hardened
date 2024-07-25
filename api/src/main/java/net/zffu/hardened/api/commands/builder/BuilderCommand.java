package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.CommandExecution;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.commands.validator.nodes.NodeCommandValidator;
import net.zffu.hardened.api.context.CommandContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BuilderCommand implements Command {

    protected String primaryName;
    protected String[] aliases;
    protected NodeCommandValidator validator = new NodeCommandValidator();
    protected CommandExecution execution;
    protected List<Argument> arguments = new ArrayList<>();

    public BuilderCommand(String primaryName) {
        this.primaryName = primaryName;
    }

    @Override
    public @NotNull String getPrimaryName() {
        return this.primaryName;
    }

    @Override
    public @NotNull String[] getAliases() {
        return this.aliases;
    }

    @Override
    public @NotNull List<Argument> getArguments() {
        return this.arguments;
    }

    @Nullable
    @Override
    public CommandValidator getValidator() {
        return this.validator;
    }

    @Override
    public void execute(@NotNull CommandContext commandContext) {
        this.execution.execute(commandContext);
    }
}
