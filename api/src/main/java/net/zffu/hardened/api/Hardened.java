package net.zffu.hardened.api;

import net.zffu.hardened.api.invoker.CommandInvoker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.UUID;

/**
 * <p>The base of the Hardened API.</p>
 * @since 1.0.0
 */
public abstract class Hardened {

    /**
     * <p>The core instance of the Hardened API. Is modified by platforms</p>
     */
    private static Hardened instance;

    /**
     * <p>The currently created invokers.</p>
     */
    private HashMap<UUID, CommandInvoker> storedInvokers;

    /**
     * <p>The invoker of the console.</p>
     */
    public final CommandInvoker consoleInvoker;

    public Hardened(CommandInvoker consoleInvoker) {
        this.consoleInvoker = consoleInvoker;
    }


    /**
     * <p>Gets the current {@link Hardened} instance.</p>
     * @return the instance or null if it's not initialized yet.
     */
    public static @Nullable Hardened getInstance() {
        return instance;
    }

    /**
     * <p>Gets the invoker for the Player</p>
     * @param playerUUID the player UUID
     * @return the invoker
     */
    public CommandInvoker getPlayerInvoker(UUID playerUUID) {
        return this.storedInvokers.get(playerUUID);
    }

    /**
     * <p>Registers the event listeners to automatically create/delete player invoker instances.</p>
     */
    public abstract void registerPlayerInvokerListeners();

    /**
     * <p>Unregisters the event listeners to automatically create/delete player invoker instances.</p>
     */
    public abstract void unregisterPlayerInvokerListeners();

    /**
     * <p>Creates an invoker for the player.</p>
     */
    public abstract void createPlayerInvoker();

}
