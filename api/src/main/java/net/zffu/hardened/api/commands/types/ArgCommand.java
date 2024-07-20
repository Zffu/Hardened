package net.zffu.hardened.api.commands.types;

import net.zffu.hardened.api.args.Argument;
import net.zffu.hardened.api.commands.validator.CommandValidator;
import org.jetbrains.annotations.NotNull;

/**
 * <p>A command that has argument(s) registered into it.</p>
 * <p><b>Warn: </b>No checks for this are there by default, those checks should be implemented in the {@link CommandValidator}</p>
 * @since 1.0.0
 */
public interface ArgCommand {

    /**
     * <p>Gets the arguments that the command contains. Used in argument parsing</p>
     * @return the command arguments as an {@link Argument[]}
     */
    @NotNull Argument[] getArguments();

}
