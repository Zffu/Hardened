package net.zffu.hardened.api.invoker;

/**
 * <p>A player from the proxy perspective.</p>
 * @since 1.0.0
 */
public interface ProxyPlayerInvoker extends BasePlayerInvoker {

    /**
     * Sends the player to the given server
     * @param serverID the ID of the server
     */
    void sendTo(String serverID);

    /**
     * Gets the current server of the player.
     * @return the ID of the server.
     */
    String getCurrentServer();


}
