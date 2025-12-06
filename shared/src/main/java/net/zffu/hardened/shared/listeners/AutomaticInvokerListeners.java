package net.zffu.hardened.shared.listeners;

import net.zffu.hardened.api.Hardened;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.shared.SharedInvokerFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * <p>The listeners for automatic invoker creation / deletion.</p>
 * @since 1.0.0
 */
public class AutomaticInvokerListeners implements Listener {

    private final Hardened instance;

    public AutomaticInvokerListeners(Hardened instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        this.instance.storedInvokers.put(player.getUniqueId(), SharedInvokerFactory.INSTANCE.createInvoker(player, InvokerType.PLAYER));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        this.instance.storedInvokers.remove(player.getUniqueId());
    }

}
