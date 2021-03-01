package fr.jp.thread;

import fr.jp.thread.entity.Baignoire;
import fr.jp.thread.entity.Robinet;

public class ThreadTest {
    public static void main(String[] args) {
        Baignoire baignoire = new Baignoire(543, 30);
        Robinet robinet = new Robinet(baignoire, 50);

        Thread threadBaignoire = new Thread(baignoire);
        Thread threadRobinet = new Thread(robinet);

        threadRobinet.start();
        threadBaignoire.start();
    }
}
