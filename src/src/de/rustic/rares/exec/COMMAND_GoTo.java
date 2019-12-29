package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_GoTo extends Command {
    public COMMAND_GoTo(String Goto) {
        super(Goto);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {

            ProxiedPlayer pp = (ProxiedPlayer) commandSender;
            if (strings.length == 1) {
                if (Utils.joinmes.containsKey(strings[0])) {

                    ServerInfo s = Utils.joinmes.get(strings[0]);

                    if (s.canAccess(pp)) {

                        pp.connect(s);

                    } else {

                    }

                } else {
                    pp.sendMessage("§c Diesen Key gibt es nicht!");
                }
            } else {
                pp.sendMessage("§c Bitte benutze /goto [ID] ");
            }
        }
    }
}
