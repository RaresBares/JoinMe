package de.rustic.rares.joinme;


import de.rustic.rares.exec.COMMAND_goto;
import de.rustic.rares.exec.COMMAND_joinme;
import de.rustic.rares.mysql.MySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class JoinMe extends Plugin {



    @Override
    public void onEnable(){
        try {
            MySQL.connect("localhost", "mein", "","");
            MySQL.CreateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_joinme("joinme"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_goto("goto"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_goto("goto"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new COMMAND_goto("goto"));
    }

    @Override
    public void onDisable() {

    }

}
