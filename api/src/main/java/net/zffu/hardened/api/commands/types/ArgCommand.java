package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.args.Argument;
import org.jetbrains.annotations.NotNull;

/**
 * A command that has {@link Argument}.
 * @since 1.0.0
 */
public interface ArgCommand {

    /**
     * Gets the {@link Argument} of the {@link net.zffu.hardened.api.commands.Command}.
     * @return
     */
    @NotNull Argument[] getArguments();

}
