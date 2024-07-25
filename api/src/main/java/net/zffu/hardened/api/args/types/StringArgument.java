package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A String {@link ArgumentType}.</p>
 * @since 1.0.0
 */
public class StringArgument implements ArgumentType<String> {

    @Override
    public String fromString(String s) {
        return s;
    }

    @Override
    public boolean canParse(@NotNull String s) {
        return true;
    }
}
