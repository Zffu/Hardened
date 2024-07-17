package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import org.bukkit.plugin.Plugin;

/**
 * A {@link net.zffu.hardened.api.registrar.CommandRegistrar} for Spigot platforms.
 * @since 1.0.0
 */
public class SpigotCommandRegistrar implements CommandRegistrar {

    private Plugin plugin;

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link Plugin}
     * @param plugin
     */
    public SpigotCommandRegistrar(Plugin plugin) {
        this.plugin = plugin;
    }

    public void register(Command<?> command) {
        //todo: add registration
    }
}
