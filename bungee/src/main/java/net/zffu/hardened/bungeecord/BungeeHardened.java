package net.zffu.hardened.bungeecord;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.zffu.hardened.api.Hardened;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;

import java.util.UUID;

public class BungeeHardened extends Hardened {

    public final Plugin plugin;

    public BungeeHardened(Plugin plugin) {
        super(new BungeeInvoker(plugin.getProxy().getConsole(), InvokerType.CONSOLE));

        this.plugin = plugin;
    }

    @Override
    public void registerPlayerInvokerListeners() {

    }

    @Override
    public void createPlayerInvoker(UUID playerUUID) {
        if(this.storedInvokers.containsKey(playerUUID)) return;

        ProxiedPlayer player = this.plugin.getProxy().getPlayer(playerUUID);
        if(player == null) return;

        this.storedInvokers.put(playerUUID, new BungeeInvoker(player, InvokerType.PLAYER));
    }
}
