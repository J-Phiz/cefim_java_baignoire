package fr.jp.thread.entity;

import static java.lang.Thread.sleep;

public class Robinet implements Runnable {

    private final Baignoire baignoire;
    private final int debit;

    public Robinet(Baignoire baignoire, int debit) {
        this.baignoire = baignoire;
        this.debit = debit;
    }

    public void debite() {
        while (true) {
            synchronized (baignoire) {
                baignoire.setVolume(Math.min(baignoire.getVolume() + debit, baignoire.getVolumeMax()));
            }
            if (baignoire.getVolume() != baignoire.getVolumeMax()) {
                System.out.println(baignoire);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        debite();
    }
}
