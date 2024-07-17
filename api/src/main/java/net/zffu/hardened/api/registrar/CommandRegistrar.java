package net.zffu.hardened.api.registrar;

import net.zffu.hardened.api.commands.Command;

/**
 * Used to register {@link net.zffu.hardened.api.commands.Command} into multiple platforms.
 * @since 1.0.0
 */
public interface CommandRegistrar {

    /**
     * Registers the provided {@link Command}.
     * @param command
     */
    void register(Command<?> command);

}
