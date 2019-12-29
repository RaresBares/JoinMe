package de.rustic.rares.exec;

import de.rustic.rares.cord.Map_Utils;
import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class COMMAND_joinme extends Command {
    public COMMAND_joinme(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer pp = (ProxiedPlayer) commandSender;
        if (strings.length == 0) {
            if (Utils.HasEnoughTokens(pp)) {
                for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {



                    try {
                        String[][] msg = Utils.getMessage(pp);
                        for(int x = 1; x <= 8; x++){
                           String m = "";
                            for(int y = 1; y <= 8; y++){
                                m += msg[x -1][y- 1];

                            }
                            pp.sendMessage(insert(m, "§", 2) +  "\n");

                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String key = Utils.setnewEntry(pp);
                    if (key != null) {


                        //    tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/goto " + key));
                    }

                }
            } else {

            }
        } else {

            pp.sendMessage("Du benutzt den falschen Command");

        }
    }
    public static String insert(String text, String insert, int period) {
        Pattern p = Pattern.compile("(.{" + period + "})", Pattern.DOTALL);
        Matcher m = p.matcher(text);
        return m.replaceAll("$1" + insert);
    }
}
