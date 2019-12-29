package de.rustic.rares.api;

import de.rustic.rares.mysql.Utils;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class Interacts {

    public  void addtokens(UUID u, int i){
        try {
            Utils.setToken(u, Utils.getTokens(u) + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void removetokens(UUID u, int i){
        try {
            Utils.setToken(u, Utils.getTokens(u) - i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void settokens(UUID u, int i){
        try {
            Utils.setToken(u, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  boolean hasEnoughTokens(UUID u){
      return   Utils.HasEnoughTokens(u);
    }



}
