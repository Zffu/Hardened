package net.zffu.hardened.api.commands.builder;

/**
 * <p>Simple way to create commands in Hardened.</p>
 * @since 1.0.0
 * @see {@link net.zffu.hardened.api.commands.Command}
 */
public class CommandBuilder extends BuilderCommand {

    public CommandBuilder(String primaryName) {
        this.primaryName = primaryName;
    }

    /**
     * Sets the aliases of the command.
     * @param aliases
     * @return
     */
    public CommandBuilder aliases(String... aliases) {
        this.aliases = aliases;
        return this;
    }

}
