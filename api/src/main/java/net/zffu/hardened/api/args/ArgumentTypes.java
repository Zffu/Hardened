package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.types.IntegerArgument;
import net.zffu.hardened.api.args.types.StringArgument;

/**
 * <p>An enum containing instances of each argument type that is in the Hardened API.</p>
 * @since 1.0.0
 */
public enum ArgumentTypes {

    STRING(new StringArgument()),
    INT(new IntegerArgument());

    private ArgumentType<?> type;

    private ArgumentTypes(ArgumentType<?> type) {
        this.type = type;
    }

    /**
     * Gets the corresponding {@link ArgumentType} instance.
     * @return
     */
    public ArgumentType<?> get() {
        return this.type;
    }

}
