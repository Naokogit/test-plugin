package me.naoko.testjavaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        Player target;

        if(args.length == 1) {
            target = Bukkit.getServer().getPlayerExact(args[0]);

            if(target == null){
                p.sendMessage(ChatColor.RED + " Player non trovato");
                return true;
            }
        } else {
            target = p;
        }
        if(p != target)
            p.sendMessage(ChatColor.GREEN + " Hai curato " + p.getDisplayName());
        target.sendMessage(ChatColor.RED + " Sei stato curato!");

        target.setHealth(target.getMaxHealth());
        target.setFoodLevel(20);

        return true;
    }
}