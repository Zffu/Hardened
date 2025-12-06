package net.zffu.hardened.bungeecord.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.bungeecord.BungeeHardened;
import net.zffu.hardened.bungeecord.BungeePlayerInvoker;

/**
 * <p>The listeners for automatic invoker creation / deletion.</p>
 * @since 1.0.0
 */
public class AutomaticInvokerListeners implements Listener {

    private final BungeeHardened instance;

    public AutomaticInvokerListeners(BungeeHardened instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerJoin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();

        this.instance.storedInvokers.put(player.getUniqueId(), new BungeePlayerInvoker(player));
    }

    @EventHandler
    public void onPlayerQuit(PlayerDisconnectEvent event) {
        this.instance.storedInvokers.remove(event.getPlayer().getUniqueId());
    }

}
