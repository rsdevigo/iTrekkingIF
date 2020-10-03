/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.rsdevigo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.github.kevinsawicki.http.HttpRequest;

/**
 *
 * @author ja731j
 */
public class iTrekkingIF extends JavaPlugin {

    public static Connection connection;

    @Override
    public void onEnable() {
        getLogger().info("The iTrekkingIF plugin has been loaded");
        getServer().getPluginManager().registerEvents(new PlayerPressureListener(), this);
    }

    @Override
    public void onDisable() {
        try { // using a try catch to catch connection errors (like wrong sql password...)
            if (connection != null && !connection.isClosed()) { // checking if connection isn't null to
                connection.close(); // closing the connection field variable.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getLogger().info("The iTrekkingIF plugin has been unloaded");
    }
}
