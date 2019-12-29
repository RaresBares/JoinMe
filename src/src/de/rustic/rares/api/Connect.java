package de.rustic.rares.api;

import de.rustic.rares.mysql.MySQL;

public class Connect {

    public static Interacts init(String HOST,String  DATABASE, String USER, String PASSWORD){
        try {
            MySQL.connect(HOST,DATABASE,USER,PASSWORD);
            Interacts i = new Interacts();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
