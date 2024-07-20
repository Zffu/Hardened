package net.zffu.hardened.api.registrar;

import net.zffu.hardened.api.commands.Command;
import org.jetbrains.annotations.NotNull;

/**
 * <p>The interface of a command registrar. Using this registrar system allows for potentially multiple platform registration in the same code.</p>
 * <p>A command registrar is the way to register commands onto a platform. Each platform that has a Hardened implementation will come with a already made {@link CommandRegistrar}.</p>
 * <p>It is generally recommend to only create a single registrar and registering your commands trough it.</p>
 * @since 1.0.0
 * @see {@link Command}
 */
public interface CommandRegistrar {

    /**
     * <p>Processes the provided {@link Command} and tries to register it inside the {@link CommandRegistrar}.</p>
     * @param command the command to register into the registrar.
     */
    void register(@NotNull Command<?> command);

}
