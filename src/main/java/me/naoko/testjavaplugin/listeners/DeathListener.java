package me.naoko.testjavaplugin.listeners;

import me.naoko.testjavaplugin.TestJavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    private final TestJavaPlugin instanceAccess;

    public DeathListener(TestJavaPlugin instanceAccess){
        this.instanceAccess = instanceAccess;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
    }

}
