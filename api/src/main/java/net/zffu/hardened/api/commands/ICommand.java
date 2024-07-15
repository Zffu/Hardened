package net.zffu.hardened.api.commands;

/**
 * The base of every command created trough the Hardened API.
 * @since 0.0.1
 */
public interface ICommand {

    /**
     * Gets the primary name and aliases of the command.
     * @return all of the command names of the command.
     */
    String getNames();

}
