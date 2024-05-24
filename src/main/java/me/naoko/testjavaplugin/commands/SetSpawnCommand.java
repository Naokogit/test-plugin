package me.naoko.testjavaplugin.commands;

import me.naoko.testjavaplugin.TestJavaPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {

    private final TestJavaPlugin plugin;

    public SetSpawnCommand(TestJavaPlugin instance){
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(!(sender instanceof Player))
            return false;

        Player p = (Player)sender;

        Location loc = p.getLocation();

// Primo metodo
//        plugin.getConfig().set("spawn.x", loc.getX());
//        plugin.getConfig().set("spawn.y", loc.getY());
//        plugin.getConfig().set("spawn.z", loc.getZ());
//        plugin.getConfig().set("spawn.worldName", loc.getWorld().getName());


        plugin.getConfig().set("spawn", loc); // Ti piazza già tutto
        plugin.saveConfig();

        p.sendMessage("Spawn point settato");


        return true;
    }
}
