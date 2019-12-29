package de.rustic.rares.exec;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class COMMAND_JoinMe extends Command {
    public COMMAND_JoinMe(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer pp = (ProxiedPlayer) commandSender;
        if (strings.length == 0) {
            if (Utils.HasEnoughTokens(pp)) {
                for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {


                    try {
                        p.sendMessage("§7§m<-------------------------------------->");
                        String[][] msg = Utils.getMessage(pp);
                        for (int x = 1; x <= 8; x++) {
                            String m = "";
                            for (int y = 1; y <= 8; y++) {
                                m += msg[y - 1][x - 1];

                            }
                            m = "§" + insert(m, "§", 2);

                            if (x == 3) {
                                m += "§7   " + pp.getName() + " §espielt auf";
                            }
                            if (x == 4) {
                                m += "§a   " + pp.getServer().getInfo().getName();
                            }
                            if (x == 6) {
                                m += "  §aKlick um zu joinen!";
                            }
                            m += " ";

                            TextComponent tc = new TextComponent(m.replace("r", "a"));

                            String key = Utils.setnewEntry(pp);
                            tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/goto " + key));
                            TextComponent[] texts = new TextComponent[3];
                            texts[0] = new TextComponent("§aServer: §e" + pp.getServer().getInfo().getName() + "\n");
                            texts[1] = new TextComponent("§aPlayers: §e" + pp.getServer().getInfo().getPlayers() + "\n");
                            texts[2] = new TextComponent("§aAdresse: §e" + pp.getServer().getInfo().getAddress());
                            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, texts));
                            tc.setText(tc.getText().replace("r", ""));
                            p.sendMessage(tc);


                        }
                        p.sendMessage("§7§m<-------------------------------------->");


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String key = Utils.setnewEntry(pp);
                    if (key != null) {


                    }

                }
            } else {
                try {
                    pp.sendMessage("§c Du hast nicht genug Tokens!(Deine Tokens: " + Utils.getTokens(pp) + ")");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {

            pp.sendMessage("§c Bitte benutze /joinme");

        }
    }

    public static String insert(String text, String insert, int period) {
        Pattern p = Pattern.compile("(.{" + period + "})", Pattern.DOTALL);
        Matcher m = p.matcher(text);
        return m.replaceAll("$1" + insert);
    }
}
