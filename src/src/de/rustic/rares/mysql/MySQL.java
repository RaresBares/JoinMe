package de.rustic.rares.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {

    public static Connection con;

    public static void connect(String HOST, String DATABASE, String USER, String PASSWORD) throws Exception {

        con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);


    }

    public static void CreateTable() throws SQLException {
        PreparedStatement preparedStmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS JoinMe (UUID VARCHAR(100), TOKENS INTEGER(100))");
        preparedStmt.executeUpdate();

    }


}
