package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.commands.validator.CommandValidator;

/**
 * <p>A command that can be simply toggled to be disabled or not. While being disabled, the command logic will never run.</p>
 * <p><b>Warn: </b>No checks for this are there by default, those checks should be implemented in the {@link CommandValidator}</p>
 * @since 1.0.0
 */
public interface DisabledCommand {

    /**
     * <p>Determines if the command is disabled currently.</p>
     * @return
     */
    boolean isDisabled();

}
