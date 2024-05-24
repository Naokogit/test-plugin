package me.naoko.testjavaplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.GRAY + p.getDisplayName() + " è uscito, dio madonna");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.DARK_PURPLE + p.getDisplayName() + " è entrato nel server per la prima volta");
            return;
        }

        if(p.getName().equals("Naoko__")){
            e.setJoinMessage(ChatColor.RED + p.getDisplayName() + " (Il capo di tutto) è entrato nel server");
        } else
            e.setJoinMessage(ChatColor.GRAY + p.getDisplayName() + " è entrato nel server GG IL WP");

    }


}
