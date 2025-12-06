package net.zffu.hardened.bungeecord;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.zffu.hardened.api.Hardened;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.bungeecord.listeners.AutomaticInvokerListeners;

import java.util.UUID;

/**
 * <p>The Hardened API implementation for Bungeecord</p>
 * @since 1.0.0
 */
public class BungeeHardened extends Hardened {

    public final Plugin plugin;

    public BungeeHardened(Plugin plugin) {
        super(new BungeeConsoleInvoker(plugin.getProxy().getConsole()));

        this.plugin = plugin;
    }

    @Override
    public void registerPlayerInvokerListeners() {
        this.plugin.getProxy().getPluginManager().registerListener(this.plugin, new AutomaticInvokerListeners(this));
    }

    @Override
    public void createPlayerInvoker(UUID playerUUID) {
        if(this.storedInvokers.containsKey(playerUUID)) return;

        ProxiedPlayer player = this.plugin.getProxy().getPlayer(playerUUID);
        if(player == null) return;

        this.storedInvokers.put(playerUUID, new BungeePlayerInvoker(player));
    }
}
