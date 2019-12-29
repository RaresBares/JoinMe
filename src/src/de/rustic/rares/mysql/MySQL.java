package de.rustic.rares.mysql;

import com.mysql.jdbc.MySQLConnection;

import java.sql.*;

public class MySQL {

    public static Connection con;

    public static void connect(String HOST,String  DATABASE, String USER, String PASSWORD) throws Exception {

        con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);


    }

    public static void CreateTable() throws SQLException {
        PreparedStatement preparedStmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS JoinMe (UUID VARCHAR(100), TOKENS INTEGER(100))");
       preparedStmt.executeUpdate();

    }




}
