package de.rustic.rares.exec;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Joinme extends Command {
    public Command_Joinme(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
            ProxiedPlayer pp = (ProxiedPlayer) commandSender;
            if(strings.length == 0){

            }else{

                pp.sendMessage("Du benutzt den falschen COmmand");

            }
    }
}
