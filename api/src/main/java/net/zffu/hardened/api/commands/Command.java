package net.zffu.hardened.api.commands;

/**
 * A Simple command from the Hardened API.
 * @since 0.0.1
 */
public class Command {

    /**
     * Names of the {@link Command}. The first element is the primary name, the other ones are aliases.
     */
    private String[] names;

    /**
     * Constructs a new {@link Command}.
     * @param names the names (aliases + the primary name) of the command.
     */
    public Command(String... names) {
        this.names = names;
    }

    /**
     * Gets all of the aliases of the command.
     * @return
     */
    public String[] getNames() {
        return this.names;
    }

}
