package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.Util;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_joinme extends Command {
    public COMMAND_joinme(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
            ProxiedPlayer pp = (ProxiedPlayer) commandSender;
            if(strings.length == 0){
                if(Utils.HasEnoughTokens(pp)){
                    for(ProxiedPlayer p : ProxyServer.getInstance().getPlayers()){

                        TextComponent tc = new TextComponent("Klick mal hier :D");
                        String key = Utils.setnewEntry(pp);
                        tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "goto " + key));
                    }
                }
            }else{

                pp.sendMessage("Du benutzt den falschen Command");

            }
    }
}
