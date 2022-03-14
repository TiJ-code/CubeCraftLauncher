package de.tij.cubecraftlauncher.gui;

import de.tij.cubecraftlauncher.gui.GUI;
import de.tij.cubecraftlauncher.utils.Vars;

import javax.swing.*;
import java.awt.*;

public class ContentDrawer extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, GUI.WIDTH, GUI.HEIGHT);

        // Titlebar
        g.setColor(Vars.BUTTON_TITLEBAR.darker());
        g.fillRect(0,0,GUI.WIDTH,30);

        // Title
        g.setColor(Color.WHITE);
        g.setFont(Vars.defaultFont);
        g.drawString("CUBECRAFT LAUNCHER", 5, 24);

        repaint();
    }
}
