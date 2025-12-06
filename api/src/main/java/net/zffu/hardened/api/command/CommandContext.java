package net.zffu.hardened.api.command;

import net.zffu.hardened.api.args.types.StringType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandContext {

    private List<String> passedArguments;
    private int currentArgumentIndex;

    private HashMap<String, Object> parsedArguments;

    public CommandContext(String[] arguments) {
        this.parsedArguments = new HashMap<>();
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

    public void appendArgument(String id, Object val) {
        this.parsedArguments.put(id, val);
    }

    public <K> K get(String argumentId) {
        return (K) this.parsedArguments.get(argumentId);
    }

}
