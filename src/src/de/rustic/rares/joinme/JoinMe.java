package de.rustic.rares.joinme;


import de.rustic.rares.cord.Map_Utils;
import de.rustic.rares.exec.COMMAND_GetTokens;
import de.rustic.rares.exec.COMMAND_SetTokens;
import de.rustic.rares.exec.COMMAND_GoTo;
import de.rustic.rares.exec.COMMAND_JoinMe;
import de.rustic.rares.mysql.MySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import java.io.*;
import java.util.Properties;

public class JoinMe extends Plugin {


    public static void main(String[] args) {

    }

    @Override
    public void onEnable(){

        Map_Utils.init();

        File f = new File("./plugins/JoinMe.properties");
        try {
            f.createNewFile();
            InputStream is = new FileInputStream(f);
            Properties pos = new Properties();
            pos.load(is);
            if(!pos.containsKey("host")){
                pos.setProperty("host", "null");
            }
            if(!pos.containsKey("database")){
                pos.setProperty("database", "null");
            }
            if(!pos.containsKey("user")){
                pos.setProperty("user", "null");
            }
            if(!pos.containsKey("passwort")){
                pos.setProperty("passwort", "null");
            }
            pos.store(new FileOutputStream(f),null);


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Properties pos = new Properties();
            InputStream is = new FileInputStream(f);
            pos.load(is);
            MySQL.connect(pos.getProperty("host"), pos.getProperty("database"), pos.getProperty("user"),pos.getProperty("passwort"));
            MySQL.CreateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_JoinMe("joinme"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_GoTo("goto"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_SetTokens("settokens"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_GetTokens("gettokens"));
    }

    @Override
    public void onDisable() {

    }

}
