package net.zffu.hardened.bungeecord.registrar;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.bungeecord.handler.BungeecordCommandHandler;
import org.jetbrains.annotations.NotNull;

public class BungeecordCommandRegistrar implements CommandRegistrar {

    protected final Plugin plugin;

    public BungeecordCommandRegistrar(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void register(@NotNull Command<?> command) {
        ProxyServer.getInstance().getPluginManager().registerCommand(this.plugin, new BungeecordCommandHandler(command));
    }

}
