package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.spigot.handler.SpigotCommand;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * A {@link SpigotCommandRegistrar} with Reflection.
 * Doesn't require any plugin.yml modifications since Reflection is used.
 */
public class ReflectionSpigotCommandRegistrar extends SpigotCommandRegistrar {

    private static CommandMap COMMAND_MAP;


    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link Plugin}
     *
     * @param plugin
     */
    public ReflectionSpigotCommandRegistrar(JavaPlugin plugin) {
        super(plugin);
        if(COMMAND_MAP == null) {
            try {
                Field field = Server.class.getDeclaredField("commandMap");
                field.setAccessible(true);
                COMMAND_MAP = (CommandMap) field.get(Bukkit.getServer());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void register(Command<?> command) {
        SpigotCommand cmd = new SpigotCommand(command);
        COMMAND_MAP.register("minecraft",cmd);
    }
}
