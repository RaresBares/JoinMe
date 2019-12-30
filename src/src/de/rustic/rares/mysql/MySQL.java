package de.rustic.rares.mysql;

import com.mojang.authlib.GameProfile;
import javafx.beans.property.Property;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {

    public static Connection con;

    public static void connect(String HOST, String DATABASE, String USER, String PASSWORD) throws Exception {

        con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);

        Player p = Bukkit.getPlayer("hey");
        GameProfile gp = ((CraftPlayer) p).getProfile();
        GameProfile profile = ((CraftPlayer) p).getProfile();
        profile.getProperties().get("textures");


    }

    public static void CreateTable() throws SQLException {
        PreparedStatement preparedStmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS JoinMe (UUID VARCHAR(100), TOKENS INTEGER(100))");
        preparedStmt.executeUpdate();

    }


}
