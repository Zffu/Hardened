package net.zffu.hardened.api.commands.types;

/**
 * A {@link net.zffu.hardened.api.commands.Command} that requires the {@link net.zffu.hardened.api.invoker.CommandInvoker} to have a specific permission.
 * @since 0.0.1
 */
public interface PermissionCommand {

    /**
     * Gets the required permission to be allowed to run this command.
     * @return
     */
    String getRequiredPermission();

}
