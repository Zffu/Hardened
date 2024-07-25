package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * <p>A list {@link ArgumentType}.</p>
 * @since 1.0.0
 */
public class ListArgument implements ArgumentType<String> {

    private List<String> choices;

    public ListArgument(List<String> choices) {
        this.choices = choices;
    }

    @Override
    public @Nullable String fromString(@NotNull String s) {
        if(this.choices.contains(s)) return s;
        return null;
    }

    @Override
    public boolean canParse(@NotNull String s) {
        return this.choices.contains(s);
    }

    public List<String> getChoices() {
        return this.choices;
    }

}
