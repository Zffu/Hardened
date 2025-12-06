package net.zffu.hardened.shared;

import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.api.invoker.WorldPlayerInvoker;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * <p>The implementation of {@link WorldPlayerInvoker} for Spigot and Paper.</p>
 */
public class SharedPlayerInvoker implements WorldPlayerInvoker {

    public final Player player;

    public SharedPlayerInvoker(Player player) {
        this.player = player;
    }

    @Override
    public void teleport(double x, double y, double z) {
        this.player.teleport(new Location(this.player.getWorld(), x, y, z));
    }

    @Override
    public void kill() {
        this.player.remove();
    }

    @Override
    public double getX() {
        return this.player.getLocation().getX();
    }

    @Override
    public double getY() {
        return this.player.getLocation().getY();
    }

    @Override
    public double getZ() {
        return this.player.getLocation().getZ();
    }

    @Override
    public String getDisplayName() {
        return this.player.getDisplayName();
    }

    @Override
    public void setDisplayName(@NotNull String name) {
        this.player.setDisplayName(name);
    }

    @Override
    public @NotNull UUID getUUID() {
        return this.player.getUniqueId();
    }

    @Override
    public void disconnect(String reason) {
        this.player.kickPlayer(reason);
    }

    @Override
    public @NotNull InvokerType getType() {
        return InvokerType.PLAYER;
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return this.player.hasPermission(permission);
    }

    @Override
    public void sendMessage(String message) {
        this.player.sendMessage(message);
    }
}
