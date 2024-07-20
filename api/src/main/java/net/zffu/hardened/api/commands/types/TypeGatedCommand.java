package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.commands.validator.CommandValidator;
import net.zffu.hardened.api.invoker.InvokerType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * <p>A command that only allows specific invoker types to execute its logic.</p>
 * <p><b>Warn: </b>No checks for this are there by default, those checks should be implemented in the {@link CommandValidator}</p>
 * @since 1.0.0
 */
public interface TypeGatedCommand {

    /**
     * <p>Gets all of the allowed {@link InvokerType} that can run the command logic.</p>
     * @return an {@link List<InvokerType>} containing the allowed {@link InvokerType}.
     */
    @NotNull List<InvokerType> getAllowedInvokers();

}
