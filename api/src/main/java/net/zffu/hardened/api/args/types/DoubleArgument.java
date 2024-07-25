package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>A double {@link ArgumentType}.</p>
 * @since 1.0.0
 */
public class DoubleArgument implements ArgumentType<Double> {

    @Override
    public @Nullable Double fromString(@NotNull String s) {
        return Double.valueOf(s);
    }

    @Override
    public boolean canParse(@NotNull String s) {
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
