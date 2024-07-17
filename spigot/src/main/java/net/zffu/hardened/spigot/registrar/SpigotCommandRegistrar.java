package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.spigot.handler.SpigotCommandHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * A {@link net.zffu.hardened.api.registrar.CommandRegistrar} for Spigot platforms.
 * @since 1.0.0
 */
public class SpigotCommandRegistrar implements CommandRegistrar {

    private JavaPlugin plugin;

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link Plugin}
     * @param plugin
     */
    public SpigotCommandRegistrar(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(Command<?> command) {
        this.plugin.getCommand(command.getPrimaryName()).setExecutor(new SpigotCommandHandler(command));
        if(command.getAliases() != null && command.getAliases().length > 0) this.plugin.getCommand(command.getPrimaryName()).setAliases(Arrays.asList(command.getAliases()));
    }
}
