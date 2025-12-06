package net.zffu.hardened.api.command;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandContext {

    private List<String> passedArguments;
    private int currentArgumentIndex;

    public CommandContext(String[] arguments) {
        this.passedArguments = Arrays.asList(arguments);
        this.currentArgumentIndex = 0;
    }

    public @Nullable String getCurrentArgument() {
        if(this.currentArgumentIndex >= this.passedArguments.size()) return null;

        return this.passedArguments.get(currentArgumentIndex);
    }

    public void incrementArgumentCount() {
        this.currentArgumentIndex++;
    }

}
