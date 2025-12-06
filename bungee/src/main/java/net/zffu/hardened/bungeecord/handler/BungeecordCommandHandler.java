package net.zffu.hardened.bungeecord.handler;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.bungeecord.BungeeInvoker;

/**
 * <p>A bungeecord handler for {@link net.zffu.hardened.api.commands.Command}.</p>
 * @since 1.0.0
 */
public class BungeecordCommandHandler extends Command {

    private final CommandRegistrar registrar;
    private final net.zffu.hardened.api.commands.Command command;
    private boolean parseArgs;

    public BungeecordCommandHandler(net.zffu.hardened.api.commands.Command command, CommandRegistrar registrar) {
        super(command.getPrimaryName(), "", command.getAliases());
        this.command = command;
        this.registrar = registrar;
        this.parseArgs = !this.command.getArguments().getArguments().isEmpty();
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        CommandInvoker invoker = commandSender instanceof ProxiedPlayer ? this.registrar.instance.getPlayerInvoker(((ProxiedPlayer) commandSender).getUniqueId()) : this.registrar.instance.consoleInvoker;

        CommandContext ctx = new CommandContext(
                invoker,
                (this.parseArgs ? CommandContext.preFormatArguments(this.command, args) : null),
                this.getName()
        );

        this.command.execute(ctx);
    }
}
