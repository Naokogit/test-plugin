package me.naoko.testjavaplugin;

import me.naoko.testjavaplugin.commands.GodCommand;
import me.naoko.testjavaplugin.commands.HealCommand;
import me.naoko.testjavaplugin.commands.SetSpawnCommand;
import me.naoko.testjavaplugin.commands.SpawnCommand;
import me.naoko.testjavaplugin.listeners.BlockBreakListener;
import me.naoko.testjavaplugin.listeners.DeathListener;
import me.naoko.testjavaplugin.listeners.JoinLeaveListener;
import me.naoko.testjavaplugin.listeners.XPBottleBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class TestJavaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {


        // config.yml

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getLogger().info("Ciao bello");
        getCommand("ciao").setExecutor(new CiaoCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        //getServer().getPluginManager().registerEvents(this, this); implements Listeners
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private class CiaoCommand implements CommandExecutor {

        @Override
        public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(("Ciao, " + p.getName() + "!"));
                return true;
            }
            return false;
        }
    }
}
