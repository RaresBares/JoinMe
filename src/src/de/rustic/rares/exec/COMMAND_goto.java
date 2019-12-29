package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_goto extends Command {
    public COMMAND_goto(String Goto) {
        super(Goto);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer){
            if(strings.length == 1){
                if(Utils.joinmes.containsKey(strings[0])){

                    ServerInfo s = Utils.joinmes.get(strings[0]);
                    ProxiedPlayer pp = (ProxiedPlayer) commandSender;
                    if(s.canAccess(pp)){

                        pp.connect(s);
                        pp.sendMessage("Du wurdest teleportiert");
                    }else{

                    }

                }
            }
        }
    }
}
