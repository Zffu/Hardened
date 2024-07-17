package net.zffu.hardened.spigot.handler;

import net.zffu.hardened.api.context.CommandContext;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * <p>A handler for {@link net.zffu.hardened.api.commands.Command}.</p>
 * @since 1.0.0
 */
public class SpigotCommandHandler implements CommandExecutor {

    private net.zffu.hardened.api.commands.Command<?> command;

    public SpigotCommandHandler(net.zffu.hardened.api.commands.Command<?> command) {
        this.command = command;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
