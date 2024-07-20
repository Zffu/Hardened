package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A command that only allows invoker with a specific permission to execute its logic.</p>
 * <p><b>Warn: </b>No checks for this are there by default, those checks should be implemented in the {@link CommandValidator}</p>
 * @since 1.0.0
 */
public interface PermissionCommand {

    /**
     * <p>Gets the permission that the {@link CommandInvoker} should have to be able to run the command.</p>
     * @return
     */
    @NotNull String getRequiredPermission();

}
