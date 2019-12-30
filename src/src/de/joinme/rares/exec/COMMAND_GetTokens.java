package de.joinme.rares.exec;

import de.joinme.rares.mysql.Utils;
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
        ProxiedPlayer pp;
        if (commandSender.hasPermission("tokens.get") || commandSender.hasPermission("*")) {
            if (strings.length == 1) {
                pp = ProxyServer.getInstance().getPlayer(strings[0]);
                if (pp != null) {
                    try {
                        commandSender.sendMessage("§a Der Spieler §e" + pp.getName() + "§a hat §8" + Utils.getTokens(pp.getUniqueId())+ " §aTokens");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    pp.sendMessage("§c Der Spieler ist nicht online/existiert nicht");
                }
            } else if(strings.length == 0){
               pp = (ProxiedPlayer) commandSender;

                if (pp != null) {
                    try {
                        commandSender.sendMessage("§a Der Spieler §e" + pp.getName() + "§a hat §8" + Utils.getTokens(pp.getUniqueId())+ " §aTokens");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    commandSender.sendMessage("§c Der Spieler ist nicht online/existiert nicht");
                }
            }else{
                commandSender.sendMessage("§c Bitte benutze /settokens [Spieler] [Zahl]");
            }
        } else {
            commandSender.sendMessage("§c Du hast dazu keine Rechte");
        }
    }
}
