package net.zffu.hardened.paper.brigadier;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.zffu.hardened.api.args.ArgumentTypes;

/**
 * <p>Allows to convert Hardened Argument types into Brigadier argument types.</p>
 */
public enum BrigadierArgumentTable {

    STRING(StringArgumentType.string()),
    INT(IntegerArgumentType.integer());


    private ArgumentType type;

    private BrigadierArgumentTable(ArgumentType type) {
        this.type = type;
    }

    public ArgumentType get() {
        return this.type;
    }

    public static ArgumentType from(ArgumentTypes types) {
        return BrigadierArgumentTable.values()[types.ordinal()].get();
    }

}
