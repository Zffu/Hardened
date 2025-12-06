package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.spigot.SpigotHardened;
import net.zffu.hardened.spigot.handler.SpigotCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A reflection-less {@link net.zffu.hardened.api.registrar.CommandRegistrar} for Spigot platforms.
 * <p>Since spigot api is bad, aliases aren't supported by the reflection-less version.</p>
 * @since 1.0.0
 */
public class SpigotCommandRegistrar extends CommandRegistrar<SpigotHardened> {

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link JavaPlugin}
     * @param instance the Hardened instance.
     */
    public SpigotCommandRegistrar(SpigotHardened instance) {
        super(instance);
    }

    public void register(Command<?> command) {
        this.instance.plugin.getCommand(command.getPrimaryName()).setExecutor(new SpigotCommandHandler(command, this));
    }
}
