package net.zffu.hardened.api.args;

import net.zffu.hardened.api.args.types.IntegerArgument;
import net.zffu.hardened.api.args.types.StringArgument;

/**
 * The available types of {@link ArgumentType} in the Hardened API.
 * @since 0.0.1
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
