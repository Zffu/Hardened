package net.zffu.hardened.api.registrar;

import net.zffu.hardened.api.commands.Command;
import org.jetbrains.annotations.NotNull;

/**
 * Used to register {@link net.zffu.hardened.api.commands.Command} into multiple platforms.
 * @since 1.0.0
 */
public interface CommandRegistrar {

    /**
     * Registers the provided {@link Command}.
     * @param command
     */
    void register(@NotNull Command<?> command);

}
