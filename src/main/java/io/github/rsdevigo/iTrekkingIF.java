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

/**
 *
 * @author ja731j
 */
public class iTrekkingIF extends JavaPlugin{
    final String username="root"; //Enter in your db username
    final String password="root"; //Enter your password for the db
    final String url = "jdbc:mysql://localhost:3306/mine?autoReconnect=true&useSSL=false"; //Enter URL w/db name
    public static Connection connection;

    
        @Override
    public void onEnable() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        getLogger().info("The iTrekkingIF plugin has been loaded");
        getServer().getPluginManager().registerEvents(new PlayerPressureListener(), this);
    }

    @Override
    public void onDisable() {
        try { //using a try catch to catch connection errors (like wrong sql password...)
            if (connection!=null && !connection.isClosed()){ //checking if connection isn't null to
                connection.close(); //closing the connection field variable.
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        getLogger().info("The iTrekkingIF plugin has been unloaded");
    }
    
    // @Override
    // public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    //     if(sender instanceof Player){
    //         Player player = (Player)sender;
    //         player.sendMessage("Hello, "+player.getName()+"!");
    //     }else{
    //         sender.sendMessage("This command can only be run by players!");
    //     }
    //     return true;
    // }
}
