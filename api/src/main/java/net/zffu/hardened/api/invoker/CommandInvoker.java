package net.zffu.hardened.api.invoker;

import org.jetbrains.annotations.NotNull;
import net.zffu.hardened.api.context.CommandContext;
import net.zffu.hardened.api.commands.types.PermissionCommand;

/**
 * <p>An invoker is something that is at the origin of a command execution.</p>
 * <p>The {@link CommandInvoker} will be provided by the {@link CommandContext} when a command gets executed.</p>
 */
public interface CommandInvoker {

    /**
     * <p>Gets the type of the {@link CommandInvoker}</p>
     * @return an {@link InvokerType} value.
     */
    @NotNull InvokerType getType();

    /**
     * <p>Determines if the {@link CommandInvoker} has the provided permission.</p>
     * <p>Used in {@link PermissionCommand} for example.</p>
     * @param permission the permission id.
     * @return true or false.
     */
    boolean hasPermission(@NotNull String permission);

}
