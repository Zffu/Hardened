package net.zffu.hardened.spigot;

import net.zffu.hardened.api.Hardened;
import net.zffu.hardened.api.invoker.CommandInvoker;
import net.zffu.hardened.api.invoker.InvokerType;
import net.zffu.hardened.shared.SharedInvokerFactory;
import net.zffu.hardened.shared.listeners.AutomaticInvokerListeners;
import net.zffu.hardened.spigot.registrar.ReflectionSpigotCommandRegistrar;
import net.zffu.hardened.spigot.registrar.SpigotCommandRegistrar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * <p>The spigot implementation of the Hardened API</p>
 * @since 1.0.0
 */
public class SpigotHardened extends Hardened {

    public final JavaPlugin plugin;

    public SpigotHardened(@NotNull JavaPlugin plugin, boolean useReflection) {
        super(SharedInvokerFactory.INSTANCE.createInvoker(plugin.getServer().getConsoleSender(), InvokerType.CONSOLE));
        this.plugin = plugin;

        if(useReflection) {
            this.commandRegistrar = new ReflectionSpigotCommandRegistrar(this);
        }
        else {
            this.commandRegistrar = new SpigotCommandRegistrar(this);
        }
    }

    @Override
    public void registerPlayerInvokerListeners() {
        this.plugin.getServer().getPluginManager().registerEvents(new AutomaticInvokerListeners(this), this.plugin);
    }

    @Override
    public void createPlayerInvoker(UUID playerUUID) {
        Player player = this.plugin.getServer().getPlayer(playerUUID);
        if(player == null) return;

        this.storedInvokers.put(playerUUID, SharedInvokerFactory.INSTANCE.createInvoker(player, InvokerType.PLAYER));
    }
}
