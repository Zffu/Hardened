package net.zffu.hardened.paper.brigadier;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.zffu.hardened.api.args.ArgumentTypes;
import net.zffu.hardened.paper.utils.DoubleFunction;

/**
 * <p>Allows to convert Hardened Argument types into Brigadier argument types.</p>
 */
public enum BrigadierArgumentTable {

    STRING(StringArgumentType.string(), (ctx, id) -> StringArgumentType.getString(ctx, id)),
    INT(IntegerArgumentType.integer(), (ctx, id) -> IntegerArgumentType.getInteger(ctx, id));


    private ArgumentType type;
    private DoubleFunction<Object, CommandContext, String> function;

    private BrigadierArgumentTable(ArgumentType type, DoubleFunction<Object, CommandContext, String> func) {
        this.type = type;
        this.function = func;
    }

    public ArgumentType get() {
        return this.type;
    }

    public static ArgumentType from(ArgumentTypes types) {
        return BrigadierArgumentTable.values()[types.ordinal()].get();
    }

    public Object getFromCtx(CommandContext ctx, String id) {
        return this.function.apply(ctx, id);
    }

}
