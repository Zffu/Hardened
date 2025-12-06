package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class DoubleType implements ArgumentType<Double> {

    private double min, max;

    public DoubleType() {
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
    }

    @Override
    public Double parse(String argumentStr) {
        try {
            double d = Double.parseDouble(argumentStr);

            if(d < this.min || d > this.max) return null;
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public DoubleType min(double min) {
        this.min = min;
        return this;
    }

    public DoubleType max(double max) {
        this.max = max;
        return this;
    }

    @Override
    public @Nullable Collection<String> getChoices() {
        return null;
    }
}
