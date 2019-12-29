package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_SetTokens extends Command {
    public COMMAND_SetTokens(String settokens) {
        super(settokens);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(strings[0]);
        if (commandSender.hasPermission("tokens.set")|| commandSender.hasPermission("*")) {
            if (strings.length == 2) {

                if (pp != null) {
                    try {
                        Utils.setToken(pp, Integer.parseInt(strings[1]));
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
