package net.zffu.hardened.brigadier.arguments;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.zffu.hardened.brigadier.utils.DoubleFunction;

/**
 * <p>Enum used to convert Hardened Argument types into Brigadier's </p>
 */
public enum BrigadierArgumentTable {

    STRING(StringArgumentType.string(), (ctx , id) -> StringArgumentType.getString(ctx, id)),
    INT(IntegerArgumentType.integer(), (ctx, id) -> IntegerArgumentType.getInteger(ctx, id));

    private ArgumentType<?> type;
    private DoubleFunction<Object, CommandContext, String> function;

    private BrigadierArgumentTable(ArgumentType type, DoubleFunction<Object, CommandContext, String> func) {
        this.function = func;
    }

    public ArgumentType get() {
        return this.type;
    }

    public Object getFromCtx(CommandContext ctx, String id) {
        return this.function.apply(ctx, id);
    }

}
