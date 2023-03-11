package fr.lightnew.tools;

import fr.lightnew.ShopMe;
import org.bukkit.ChatColor;

public class ObjectsLoad {

    public static String prefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "ShopMe" + ChatColor.GRAY + "] ";
    public static String host, database, username, password;
    public static Integer port;

    public static void init() {
        host = ShopMe.instance.getConfig().getString("Database.host");
        database = ShopMe.instance.getConfig().getString("Database.database");
        username = ShopMe.instance.getConfig().getString("Database.username");
        password = ShopMe.instance.getConfig().getString("Database.password");
        port = ShopMe.instance.getConfig().getInt("Database.port");
    }
}
