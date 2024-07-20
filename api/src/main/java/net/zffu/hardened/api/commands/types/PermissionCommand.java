package net.zffu.hardened.api.commands.types;

import org.jetbrains.annotations.NotNull;

/**
 * A {@link net.zffu.hardened.api.commands.Command} that requires the {@link net.zffu.hardened.api.invoker.CommandInvoker} to have a specific permission.
 * @since 1.0.0
 */
public interface PermissionCommand {

    /**
     * Gets the required permission to be allowed to run this command.
     * @return
     */
    @NotNull String getRequiredPermission();

}
