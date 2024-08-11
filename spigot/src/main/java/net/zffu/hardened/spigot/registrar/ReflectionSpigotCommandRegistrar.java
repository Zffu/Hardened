package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.spigot.handler.SpigotCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * A {@link SpigotCommandRegistrar} with Reflection.
 * Doesn't require any plugin.yml modifications since Reflection is used.
 */
public class ReflectionSpigotCommandRegistrar extends SpigotCommandRegistrar {

    private static CommandMap COMMAND_MAP;

    private String namespace;

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link JavaPlugin}
     * @param plugin
     */
    public ReflectionSpigotCommandRegistrar(JavaPlugin plugin) {
        super(plugin);
        this.namespace = "minecraft";
        if(COMMAND_MAP == null) initMap();
    }

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link JavaPlugin}. The registrar will register commands under the provided namespace
     * @param plugin
     */
    public ReflectionSpigotCommandRegistrar(JavaPlugin plugin, String namespace) {
        super(plugin);
        this.namespace = namespace;
        if(COMMAND_MAP == null) initMap();
    }

    private void initMap() {
        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            COMMAND_MAP = (CommandMap) field.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register(Command<?> command) {
        SpigotCommand cmd = new SpigotCommand(command);
        COMMAND_MAP.register(this.namespace,cmd);
    }
}
