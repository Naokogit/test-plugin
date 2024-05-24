package me.naoko.testjavaplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();
        Difficulty wd = p.getWorld().getDifficulty();

        if(wd == Difficulty.HARD && !(p.isOp() || p.hasPermission("*"))) {
            e.setCancelled(true);
            p.sendMessage("Non puoi spaccare questo blocco con la difficoltà! " + wd.name());
        }
    }

}
