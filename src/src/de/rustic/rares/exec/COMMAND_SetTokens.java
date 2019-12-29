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
        ProxiedPlayer pp;
        if (commandSender.hasPermission("tokens.set")|| commandSender.hasPermission("*")) {
            if (strings.length == 2) {
                pp = ProxyServer.getInstance().getPlayer(strings[0]);
                if (pp != null) {
                    try {
                        Utils.setToken(pp, Integer.parseInt(strings[1]));

                        commandSender.sendMessage("§a Der Spieler §e" + pp.getName() + "§a hat jetzt §8" + Utils.getTokens(pp)+ " §aTokens");
                        pp.sendMessage("§a Du hast jetzt §8" + Utils.getTokens(pp)+ " §aTokens");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    pp.sendMessage("§c Der Spieler ist nicht online/existiert nicht");
                }
            } else if(strings.length == 1){
               pp = (ProxiedPlayer) commandSender;
                if (pp != null) {
                    try {
                        Utils.setToken(pp, Integer.parseInt(strings[0]));

                       
                        pp.sendMessage("§a Du hast jetzt §8" + Utils.getTokens(pp)+ " §aTokens");
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
