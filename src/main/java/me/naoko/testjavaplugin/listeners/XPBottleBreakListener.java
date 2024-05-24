package me.naoko.testjavaplugin.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        e.setShowEffect(false);
        Block block = e.getHitBlock();
        if(block == null) return;
        System.out.println("block.getBlockData().getMaterial() = " + block.getBlockData().getMaterial());
    }
}
