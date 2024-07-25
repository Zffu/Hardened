package net.zffu.hardened.api.args.impl;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;

public class RangedArgument extends Argument {

    private double min;
    private double max;

    /**
     * <p>Creates a new {@link Argument}.</p>
     *
     * @param type
     */
    public RangedArgument(@NotNull ArgumentType<? extends Number> type) {
        super(type);
    }

    /**
     * Sets the max length.
     * @param max the max length
     * @return
     */
    public RangedArgument max(double max) {
        this.max = max;
        return this;
    }

    /**
     * Sets the min length.
     * @param min the min length
     * @return
     */
    public RangedArgument min(double min) {
        this.min = min;
        return this;
    }

    @Override
    public boolean canParse(String rawString) {
        if(super.canParse(rawString)) {
            Double d = Double.parseDouble(rawString);
            if(d >= this.min && d <= this.max) return true;
        }
        return false;
    }
}
