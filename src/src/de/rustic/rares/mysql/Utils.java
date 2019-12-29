package de.rustic.rares.mysql;

import de.rustic.rares.Threads.MyThread;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import static de.rustic.rares.mysql.MySQL.con;

public class Utils {

    public static HashMap<String, ServerInfo> joinmes = new HashMap<>();

    public static boolean HasEnoughTokens(ProxiedPlayer pp) {

        try {


            if (getTokens(pp) > 0) {
                setToken(pp, getTokens(pp) - 1);
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Integer getTokens(ProxiedPlayer pp) throws Exception {
        if(userexists(pp)) {
            PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM JoinMe WHERE UUID = ?");
            preparedStmt.setString(1, pp.getUniqueId().toString());
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                return rs.getInt("TOKENS");
            }
            return -1;
        }else{
            setToken(pp, 0);
            return 0;
        }
    }

    public static boolean userexists(ProxiedPlayer pp) throws Exception {
        PreparedStatement preparedStmt = con.prepareStatement("SELECT * FROM JoinMe WHERE UUID = ?");
        preparedStmt.setString(1, pp.getUniqueId().toString());
        ResultSet rs = preparedStmt.executeQuery();
        return rs.next();
    }

    public static void setToken(ProxiedPlayer pp, int i) throws Exception {
        if(!userexists(pp)){
            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO JoinMe (UUID, TOKENS) VALUES (?,?)");
            preparedStmt.setString(1, pp.getUniqueId().toString());
            preparedStmt.setInt(2, i);
            preparedStmt.executeUpdate();
        }else{
            PreparedStatement preparedStmt = con.prepareStatement("UPDATE JoinMe SET TOKENS = ? WHERE UUID = ?");
            preparedStmt.setString(2, pp.getUniqueId().toString());
            preparedStmt.setInt(1, i);
            preparedStmt.executeUpdate();
        }


    }


    public static String setnewEntry(ProxiedPlayer p){
      String a = "";
      do{
          a = "#" + UUID.randomUUID().toString().replace("-", "");
      }while (joinmes.containsKey(a));

        MyThread m = new MyThread();
        m.b = a;
        m.setDaemon(false);
        m.start();

        joinmes.put(a, p.getServer().getInfo());

      return  a;

    };

}
