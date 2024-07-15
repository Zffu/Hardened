package net.zffu.hardened.api.invoker;

/**
 * The invoker of a {@link net.zffu.hardened.api.commands.Command} call. Allows for multiplatform.
 * @since 0.0.1
 */
public interface ICommandInvoker {

    /**
     * Is the {@link ICommandInvoker} a player.
     * @return true or false
     */
    boolean isPlayer();
}
