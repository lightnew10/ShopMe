package fr.lightnew.sql;

import fr.lightnew.ShopMe;
import fr.lightnew.tools.ObjectsLoad;
import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestSQL {
    private static final Connection connection = ShopMe.instance.getConnection();

    public static void createDatabase() {
        try {
            String data =
                    "CREATE DATABASE IF NOT EXISTS " + ObjectsLoad.database;
            PreparedStatement statement1 = connection.prepareStatement(data);
            statement1.executeUpdate();
            ShopMe.log(ObjectsLoad.prefix + ChatColor.GREEN + "Database 'Jobs' is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createDefaultsTables() {
        try {
            String use = "USE " + ObjectsLoad.database + ";";
            String player_jobs =
                    "CREATE TABLE IF NOT EXISTS playerJobs(id int NOT NULL AUTO_INCREMENT," +
                            "player_uuid VARCHAR(255) NOT NULL," +
                            "notification BOOLEAN NOT NULL," +
                            "alchemist_xp DOUBLE NOT NULL," +
                            "fisherman_xp DOUBLE NOT NULL," +
                            "hunter_xp DOUBLE NOT NULL," +
                            "lumberjack_xp DOUBLE NOT NULL," +
                            "minor_xp DOUBLE NOT NULL," +
                            "peasant_xp DOUBLE NOT NULL," +
                            "smithing_xp DOUBLE NOT NULL," +
                            "PRIMARY KEY (id));";
            PreparedStatement statement = connection.prepareStatement(use);
            PreparedStatement statement2 = connection.prepareStatement(player_jobs);
            statement.executeUpdate();
            statement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
