package fr.lightnew;

import fr.lightnew.command.ShopCommand;
import fr.lightnew.events.Interaction;
import fr.lightnew.sql.RequestSQL;
import fr.lightnew.tools.ObjectsLoad;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopMe extends JavaPlugin {

    public static ShopMe instance;
    private Connection connection;

    @Override
    public void onEnable() {
        // Logic Load
        this.instance = this;
        saveDefaultConfig();
        log(ObjectsLoad.prefix + ChatColor.GREEN + "ShopMe is Enable");
        ObjectsLoad.init();
        // Listener
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new Interaction(),this);
        // Command
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("shop").setTabCompleter(new ShopCommand());
        // Database
        final String url = "jdbc:mysql://" + ObjectsLoad.host + ":" + ObjectsLoad.port + "/" + /*ObjectsPreset.database +*/ "?user=" + ObjectsLoad.username + "&password=" + ObjectsLoad.password; // Enter URL with db name
        try {
            connection = DriverManager.getConnection(url);
            log(ChatColor.GREEN + "DATABASE Jobs CONNECTED");
            /*
            RequestSQL.createDatabase();
            RequestSQL.createDefaultsTables();
            */
            log(ObjectsLoad.prefix + ChatColor.GREEN + "Data base " + ObjectsLoad.database + " ont bien été chargé.");
        } catch (SQLException e) {e.printStackTrace();}
    }

    @Override
    public void onDisable() {
        log(ObjectsLoad.prefix + ChatColor.RED + "ShopMe is Disable");
        try {
            if (!getConnection().isClosed())
                getConnection().close();
        } catch (SQLException e) {e.printStackTrace();}
        log(ObjectsLoad.prefix + ChatColor.RED + "DATABASE DISCONNECT");
    }

    public static void log(String s) {
        Bukkit.broadcastMessage(s);
    }

    public Connection getConnection() {
        return connection;
    }

}
