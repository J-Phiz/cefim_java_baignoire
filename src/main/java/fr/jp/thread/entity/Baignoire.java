package fr.jp.thread.entity;

import static java.lang.Thread.sleep;

public class Baignoire implements Runnable {

    private final int volumeMax;
    private final int volumeFuite;
    private int volume;

    public Baignoire(int volumeMax, int volumeFuite) {
        this.volumeMax = volumeMax;
        this.volumeFuite = volumeFuite;
        this.volume = 0;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0) {
            this.volume = volume;
        }
    }

    public void fuite() {
        while (true) {
            synchronized (this) {
                volume -= volumeFuite;
                if (volume < 0) {
                    volume = 0;
                }
            }
            if (volume > 0) {
                System.out.println(this);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Le volume d'eau dans la baignoire est de " + volume + " pour un max à " + volumeMax;
    }

    @Override
    public void run() {
        fuite();
    }

}
