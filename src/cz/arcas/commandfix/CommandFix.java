/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.arcas.commandfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Arcas
 */
public final class CommandFix extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable(){
        getLogger().info("Loaded");
        getLogger().info("By ArcasCZ | http://uranus-portal.com");
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @Override
    public void onDisable(){
        getLogger().info("Unloaded!");
        getLogger().info("By ArcasCZ | http://uranus-portal.com");      
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerCommandPreprocessEvent(final PlayerCommandPreprocessEvent e){
        String message = e.getMessage().toLowerCase();
        String player = e.getPlayer().getName();
        if(message.startsWith("/login ") || message.startsWith("/l ") || message.startsWith("/reg ") || message.startsWith("/changepassword ") || message.startsWith("/unregister ") || message.startsWith("/authme register ") || message.startsWith("/authme changepassword ") || message.startsWith("/authme reg ") || message.startsWith("/authme cp ") || message.startsWith("/register ")){
            System.out.println(player + " issued AuthMe command.");
        }else if (message.startsWith("/restartsrv") || message.startsWith("/holdsrv") || message.startsWith("/reschedulerestart") || message.startsWith("/stopwrapper")){
            System.out.println(player + " issued Wrapper command.");
        }else{
            System.out.println(player + " issued server command: " + message);
        }
    }
}
