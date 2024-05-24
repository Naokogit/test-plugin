package me.naoko.testjavaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        //if(!command.getName().equals("god"))
        //    return false;
        if(!(sender instanceof Player))
            return false;

        Player p = (Player)sender;
        p.sendMessage(command.toString());
        if(p.isInvulnerable()){
            p.setInvulnerable(false);
            p.sendMessage(ChatColor.RED + "God mode deactivated");
        } else {
            p.setInvulnerable(true);
            p.sendMessage(ChatColor.GREEN + "God mode activated");
        }

        return true;
    }
}
