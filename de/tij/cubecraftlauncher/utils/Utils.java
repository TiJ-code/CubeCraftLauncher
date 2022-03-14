package de.tij.cubecraftlauncher.utils;

import de.tij.cubecraftlauncher.gui.GUI;

import java.util.Timer;
import java.util.TimerTask;

public class Utils {

    private static TimerTask sizeTask;

    private static TimerTask updateLauncherTask;

    public static void startTasks() {
        setup();
        new Timer("sizeUpader").scheduleAtFixedRate(sizeTask, 0L, 50L);
    }

    private static void setup() {
        sizeTask = new TimerTask() {
            @Override
            public void run() {
                GUI.WIDTH = GUI.INSTANCE.window.getWidth();
                GUI.HEIGHT = GUI.INSTANCE.window.getHeight();
            }
        };
    }
}
