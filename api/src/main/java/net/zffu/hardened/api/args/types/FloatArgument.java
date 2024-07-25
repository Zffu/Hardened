package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>A float {@link ArgumentType}.</p>
 * @since 1.0.0
 */
public class FloatArgument implements ArgumentType<Float> {

    @Override
    public @Nullable Float fromString(@NotNull String s) {
        return Float.valueOf(s);
    }

    @Override
    public boolean canParse(@NotNull String s) {
        try {
            Float.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
