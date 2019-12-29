package de.rustic.rares.joinme;


import de.rustic.rares.cord.Map_Utils;
import de.rustic.rares.exec.COMMAND_GetTokens;
import de.rustic.rares.exec.COMMAND_SetTokens;
import de.rustic.rares.exec.COMMAND_GoTo;
import de.rustic.rares.exec.COMMAND_JoinMe;
import de.rustic.rares.mysql.MySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class JoinMe extends Plugin {


    public static void main(String[] args) {

    }

    @Override
    public void onEnable(){
        Map_Utils.init();
        try {

            MySQL.connect("localhost", "mein", "root","");
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
