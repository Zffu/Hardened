package net.zffu.hardened.api.commands.builder;

import net.zffu.hardened.api.commands.Command;

/**
 * <p>A builder for {@link Command}.</p>
 * <p>This is recommended if you want to make command fast but do not care about any minor memory usage that could result.</p>
 * @since 0.0.1
 * @see {@link Command}
 */
public class CommandBuilder {



    /**
     * <p>Variant of the {@link net.zffu.hardened.api.commands.Command} interface.</p>
     * <p>This variant isn't the default one as it implements every single feature that commands can have in the Hardened for the builder.</p>
     * <p>This means that this can be used only if you do not mind the extra memory usage that will come from the empty variable fields from the unused interfaces.</p>
     * @since 0.0.1
     */
    private class BuiltCommand implements Command {

        @Override
        public String getNames() {
            return null;
        }
    }


}
