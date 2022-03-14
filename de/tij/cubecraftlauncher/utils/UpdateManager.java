package de.tij.cubecraftlauncher.utils;

import de.tij.cubecraftlauncher.gui.GUI;

public class UpdateManager {

    private static boolean launcherFinished = false;
    private static volatile boolean gameFinished = false;

    public static void checkForLauncherUpdate() {
        try {
            Thread check = new Thread() {

            };
            check.start();
            do {
                check.join();
            } while (launcherFinished);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
