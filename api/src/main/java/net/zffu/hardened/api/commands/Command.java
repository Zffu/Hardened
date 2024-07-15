package net.zffu.hardened.api.commands;

import net.zffu.hardened.api.commands.validator.CommandValidator;

/**
 * The base of every command created trough the Hardened API.
 * @since 0.0.1
 */
public interface Command<T extends CommandValidator> {

    /**
     * Gets the primary name and aliases of the command.
     * @return all of the command names of the command.
     */
    String[] getNames();

    /**
     * <p>Gets the {@link CommandValidator} for that {@link Command}.</p>
     * <p>The {@link CommandValidator} varies depending on the implementation of the {@link Command} class used.</p>
     * @return the {@link CommandValidator}.
     */
    T getValidator();

}
