package net.zffu.hardened.api.commands;

/**
 * A Simple command from the Hardened API.
 * @since 0.0.1
 */
public class Command {

    /**
     * The name of the {@link Command}.
     */
    private String name;

    /**
     * Constructs a new {@link Command}.
     * @param name
     */
    public Command(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the command.
     * @return
     */
    public String getName() {
        return this.name;
    }


}
