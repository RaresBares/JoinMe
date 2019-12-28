package de.rustic.rares.joinme;


import de.rustic.rares.exec.Command_Joinme;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class JoinMe extends Plugin {

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command_Joinme("joinme"));
    }

    @Override
    public void onDisable() {

    }
}
