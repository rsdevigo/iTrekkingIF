/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.rsdevigo;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author ja731j
 */
public class iTrekkingIF extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("The iTrekkingIF plugin has been loaded");
        getServer().getPluginManager().registerEvents(new PlayerPressureListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The iTrekkingIF plugin has been unloaded");
    }
}
