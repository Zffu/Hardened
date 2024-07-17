package net.zffu.hardened.api.commands.types;

/**
 * A {@link net.zffu.hardened.api.commands.Command} that can be disabled or not.
 * @since 0.0.1
 */
public interface DisabledCommand {

    /**
     * Determines if the command is currently disabled.
     * @return
     */
    boolean isDisabled();

}
