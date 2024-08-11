package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.shared.SharedInvokerFactory;
import net.zffu.hardened.spigot.handler.SpigotCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A reflection-less {@link net.zffu.hardened.api.registrar.CommandRegistrar} for Spigot platforms.
 * <p>Since spigot api is bad, aliases aren't supported by the reflection-less version.</p>
 * @since 1.0.0
 */
public class SpigotCommandRegistrar implements CommandRegistrar {

    protected JavaPlugin plugin;

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link JavaPlugin}
     * @param plugin
     */
    public SpigotCommandRegistrar(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(Command<?> command) {
        this.plugin.getCommand(command.getPrimaryName()).setExecutor(new SpigotCommandHandler(command, this));
    }
}
