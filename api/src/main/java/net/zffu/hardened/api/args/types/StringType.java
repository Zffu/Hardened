package net.zffu.hardened.api.args.types;

import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;

public class StringType implements ArgumentType<String> {

    private int maxLength;

    public StringType() {
        this.maxLength = -1;
    }

    @Override
    public String parse(String argumentStr) {
        if(this.maxLength > 0 && argumentStr.length() > this.maxLength) return null;

        return argumentStr;
    }

    public StringType maxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    @Override
    public @Nullable Collection<String> getChoices() {
        return null;
    }

}
