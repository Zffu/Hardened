package net.zffu.hardened.api.invoker;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * <p>Represents a basic player invoker.</p>
 * <p>Contains every {@link CommandInvoker} access with a few more unique to players.</p>
 * <p>This isn't only Proxy players but represent players with access to positions being impossible.</p>
 */
public interface BasePlayerInvoker extends CommandInvoker {

    /**
     * Gets this player's display name.
     *
     * @return the players current display name
     */
    String getDisplayName();

    /**
     * Sets this player's display name to be used by proxy commands and plugins.
     *
     * @param name the name to set
     */
    void setDisplayName(@NotNull String name);

    /**
     * Get this connection's UUID.
     *
     * @return the UUID
     */
    @NotNull UUID getUUID();

    /**
     * Disconnects the player
     *
     * @param reason the reason
     */
    void disconnect(String reason);

}
