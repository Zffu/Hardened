package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class IntType implements ArgumentType<Integer> {

    private int min, max;

    public IntType() {
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    @Override
    public Integer parse(String argumentStr) {
        try {
            int i =  Integer.parseInt(argumentStr);

            if(i < this.min || i > this.max) return null;
            return i;
        } catch (Exception e) {
            return null;
        }
    }

    public IntType min(int min) {
        this.min = min;
        return this;
    }

    public IntType max(int max) {
        this.max = max;
        return this;
    }

    @Override
    public @Nullable Collection<String> getChoices() {
        return null;
    }
}
