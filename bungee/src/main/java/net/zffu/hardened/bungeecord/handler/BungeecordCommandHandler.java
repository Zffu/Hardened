package net.zffu.hardened.bungeecord.handler;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.zffu.hardened.api.context.CommandContext;

public class BungeecordCommandHandler extends Command {

    private final net.zffu.hardened.api.commands.Command command;
    private boolean parseArgs;

    public BungeecordCommandHandler(net.zffu.hardened.api.commands.Command command) {
        super(command.getPrimaryName(), "", command.getAliases());
        this.command = command;
        this.parseArgs = !this.command.getArguments().getArguments().isEmpty();
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

    }
}
