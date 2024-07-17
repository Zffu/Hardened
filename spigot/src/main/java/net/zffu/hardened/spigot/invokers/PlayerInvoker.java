package net.zffu.hardened.spigot.invokers;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import org.bukkit.entity.Player;

/**
 * An {@link CommandInvoker} that is a {@link org.bukkit.entity.Player}.
 * @since 1.0.0
 */
public class PlayerInvoker implements CommandInvoker {

    private Player player;

    public PlayerInvoker(Player player) {
        this.player = player;
    }

    public InvokerType getType() {
        return InvokerType.PLAYER;
    }

    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }

    public Player getPlayer() {
        return this.player;
    }
}
