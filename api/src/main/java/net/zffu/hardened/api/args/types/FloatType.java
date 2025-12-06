package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class FloatType implements ArgumentType<Float> {

    public float min, max;

    public FloatType() {
        this.min = Float.MIN_VALUE;
        this.max = Float.MAX_VALUE;
    }

    @Override
    public Float parse(String argumentStr) {
        try {
            float f = Float.parseFloat(argumentStr);

            if(f < this.min || f > this.max) return null;
            return f;
        } catch (Exception e) {
            return null;
        }
    }

    public FloatType min(float min) {
        this.min = min;
        return this;
    }

    public FloatType max(float max) {
        this.max = max;
        return this;
    }


    @Override
    public @Nullable Collection<String> getChoices() {
        return null;
    }
}
