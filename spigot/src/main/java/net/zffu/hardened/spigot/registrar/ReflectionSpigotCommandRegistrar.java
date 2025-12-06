package net.zffu.hardened.spigot.registrar;

import net.zffu.hardened.api.commands.Command;
import net.zffu.hardened.api.registrar.CommandRegistrar;
import net.zffu.hardened.spigot.SpigotHardened;
import net.zffu.hardened.spigot.handler.SpigotCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;

/**
 * A {@link SpigotCommandRegistrar} with Reflection.
 * Doesn't require any plugin.yml modifications since Reflection is used.
 */
public class ReflectionSpigotCommandRegistrar extends CommandRegistrar<SpigotHardened> {

    private static CommandMap COMMAND_MAP;

    private String namespace;

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link SpigotHardened}
     * @param instance the Hardened spigot instance.
     */
    public ReflectionSpigotCommandRegistrar(SpigotHardened instance) {
        super(instance);
        this.namespace = "minecraft";
        if(COMMAND_MAP == null) initMap();
    }

    /**
     * Constructs a new {@link SpigotCommandRegistrar} linked to the provided {@link SpigotHardened}. The registrar will register commands under the provided namespace
     * @param instance the Hardened spigot instance.
     */
    public ReflectionSpigotCommandRegistrar(SpigotHardened instance, String namespace) {
        super(instance);
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
