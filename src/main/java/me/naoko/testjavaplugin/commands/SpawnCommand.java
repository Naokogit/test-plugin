package me.naoko.testjavaplugin.commands;

import me.naoko.testjavaplugin.TestJavaPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    private final TestJavaPlugin plugin;
    public SpawnCommand(TestJavaPlugin plugin){
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        Location loc = plugin.getConfig().getLocation("spawn");

        if(loc == null) {
            System.out.println("Errore, non c'è nessun spawnpoint set");
            return false;
        }

        p.teleport(loc);
        p.sendMessage("Sei stato tippato");

        return true;
    }
}
