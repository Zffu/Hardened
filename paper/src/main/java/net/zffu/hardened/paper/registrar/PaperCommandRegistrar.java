package net.zffu.hardened.paper.registrar;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.sun.tools.javac.util.List;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.commands.types.ArgCommand;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.paper.brigadier.BrigadierArgumentTable;
import net.zffu.hardened.paper.invokers.*;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;



import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * <p>A {@link CommandRegistrar} for Paper. Must be created in the onEnable function in order to work.</p>
 * @since 1.0.0
 */
public class PaperCommandRegistrar implements CommandRegistrar {

    private Commands commands;

    /**
     * <p>Creates a new registar by hooking into Paper's</p>
     * @param javaPlugin
     */
    public PaperCommandRegistrar(JavaPlugin javaPlugin) {
        LifecycleEventManager<Plugin> manager = javaPlugin.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            this.commands = event.registrar();
        });
    }

    @Override
    public void register(@NotNull Command<?> command) {
        LiteralArgumentBuilder<CommandSourceStack> cmd = Commands.literal(command.getPrimaryName());
        if(command instanceof ArgCommand) {
            ArgCommand argCommand = (ArgCommand) command;

            int index = 0;
            for(Argument argument : argCommand.getArguments()) {
                cmd.then(Commands.argument("" + index, BrigadierArgumentTable.from(argument.getType())));
                index++;
            }
        }

        cmd.executes(ctx -> {
            Object[] args = null;
            if(command instanceof ArgCommand) {
                ArgCommand argCommand = (ArgCommand) command;
                args = new Object[argCommand.getArguments().length];

                int index = 0;
                for(Argument argument : argCommand.getArguments()) {
                    args[index] = BrigadierArgumentTable.values()[argument.getType().ordinal()].getFromCtx(ctx, "" + index);
                }
            }

            CommandContext context = new CommandContext(fromCommandSender(ctx.getSource().getSender()), args, ctx.getInput());
            command.run(context);
            return 1;
        });

        //todo: avoid Arrays.asList
        this.commands.register(cmd.build(), "", Arrays.asList(command.getAliases()));
    }

    /**
     * Turns a {@link CommandSender} into a {@link CommandInvoker}.
     * @param sender the {@link CommandSender}
     * @return the {@link CommandInvoker}
     */
    public static CommandInvoker fromCommandSender(CommandSender sender) {
        if(sender instanceof Player) return new PlayerInvoker((Player) sender);
        if(sender instanceof ConsoleCommandSender) return new ConsoleInvoker(sender);
        return new OtherInvoker(sender);
    }
}
