package net.zffu.hardened.api.args.impl;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.args.ArgumentType;
import org.jetbrains.annotations.NotNull;

public class LengthArgument extends Argument {

    private int maxLength;
    private int minLength;

    /**
     * <p>Creates a new {@link Argument}.</p>
     *
     * @param type
     */
    public LengthArgument(@NotNull ArgumentType<?> type) {
        super(type);
    }

    /**
     * Sets the max length.
     * @param maxLength the max length
     * @return
     */
    public LengthArgument max(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Sets the min length.
     * @param minLength the min length
     * @return
     */
    public LengthArgument min(int minLength) {
        this.minLength = minLength;
        return this;
    }

    @Override
    public boolean canParse(String rawString) {
        if(rawString.length() >= this.minLength && rawString.length() <= this.maxLength) {
            if(super.canParse(rawString)) return true;
        }
        return false;
    }
}
