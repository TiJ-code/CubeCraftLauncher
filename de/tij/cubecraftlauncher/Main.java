package de.tij.cubecraftlauncher;

import de.tij.cubecraftlauncher.gui.GUI;
import de.tij.cubecraftlauncher.utils.Utils;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.createGUI();
                Utils.startTasks();
            }
        });
    }
}
