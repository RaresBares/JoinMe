package de.joinme.rares.Threads;

import de.joinme.rares.mysql.Utils;

public class MyThread extends Thread {

    public String b;

    @Override
    public void run() {

        try {
            sleep(60000);
            Utils.joinmes.remove(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
