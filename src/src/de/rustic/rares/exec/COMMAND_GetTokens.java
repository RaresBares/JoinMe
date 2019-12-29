package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_GetTokens extends Command {
    public COMMAND_GetTokens(String gettokens) {
        super(gettokens);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender.hasPermission("tokens.set")) {
            if (strings.length == 1) {
                ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(strings[0]);
                if (pp != null) {
                    try {
                      commandSender.sendMessage(Utils.getTokens(pp) + "");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                }
            }
        }
    }
}
