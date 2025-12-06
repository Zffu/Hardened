package net.zffu.hardened.bungeecord;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.api.invoker.ProxyPlayerInvoker;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * <p>A bungeecord command invoker</p>
 * @since 1.0.0
 */
public class BungeePlayerInvoker implements ProxyPlayerInvoker {

    private final ProxiedPlayer player;

    public BungeePlayerInvoker(ProxiedPlayer player) {
        this.player = player;
    }

    @Override
    public void sendTo(String serverID) {
        ServerInfo info = ProxyServer.getInstance().getServerInfo(serverID);
        if(info == null) return;

        this.player.connect(info);
    }

    @Override
    public String getCurrentServer() {
        return this.player.getServer().getInfo().getName();
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
        this.player.disconnect(reason);
    }

    @Override
    public @NotNull InvokerType getType() {
        return InvokerType.PROXY_PLAYER;
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
