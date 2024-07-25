package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A int {@link ArgumentType}.</p>
 * @since 1.0.0
 */
public class IntegerArgument implements ArgumentType<Integer> {

    @Override
    public Integer fromString(String s) {
        return Integer.valueOf(s);
    }

    @Override
    public boolean canParse(@NotNull String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
