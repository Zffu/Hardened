package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.Command;

/**
 * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
 * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
 * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
 * @since 0.0.1
 * @see {@link Command}
 */
public class CommandBuilder {

}
