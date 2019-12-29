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
        ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(strings[0]);
        if (commandSender.hasPermission("tokens.get") || commandSender.hasPermission("*")) {
            if (strings.length == 1) {

                if (pp != null) {
                    try {
                        commandSender.sendMessage(Utils.getTokens(pp) + "");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    pp.sendMessage("§c Der Spieler ist nicht online/existiert nicht");
                }
            } else {
                pp.sendMessage("§c Bitte benutze /settokens [Spieler] [Zahl]");
            }
        } else {
            pp.sendMessage("§c Du hast dazu keine Rechte");
        }
    }
}
