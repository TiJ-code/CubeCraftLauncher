package de.tij.cubecraftlauncher.gui;

import de.tij.cubecraftlauncher.components.InstallButton;
import de.tij.cubecraftlauncher.components.LaunchGameButton;
import de.tij.cubecraftlauncher.components.TitlebarButton;
import de.tij.cubecraftlauncher.utils.UpdateManager;
import de.tij.cubecraftlauncher.utils.Vars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

    public JFrame window;
    ContentDrawer drawer;
    JLayeredPane pane;

    public static GUI INSTANCE;

    public GUI() {
        INSTANCE = this;
    }

    public static int WIDTH = 800, HEIGHT = 600;

    public void createGUI() {
        window = new JFrame("CubeCraftLauncher");
        window.setSize(new Dimension(WIDTH, HEIGHT));
        window.setUndecorated(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();

        window.setVisible(true);
    }

    public TitlebarButton close;
    public TitlebarButton minimize;
    public LaunchGameButton btn;
    public InstallButton installBtn;

    @SuppressWarnings("deprecated")
    private void addComponents() {
        pane = new JLayeredPane();

        drawer = new ContentDrawer();
        drawer.setBounds(0,0,WIDTH,HEIGHT);
        drawer.setVisible(true);
        pane.add(drawer, new Integer(0));

        close = new TitlebarButton("X", GUI.WIDTH-40,0,40,30);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(50);
                    System.exit(0);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        minimize = new TitlebarButton("-", GUI.WIDTH-90,0,40,30);
        minimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(50);
                    GUI.INSTANCE.window.setState(JFrame.ICONIFIED);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        pane.add(minimize, new Integer(1));
        pane.add(close, new Integer(1));

        btn = new LaunchGameButton("STARTEN", WIDTH/2-300/2, HEIGHT-75, 300, 50);
        pane.add(btn, new Integer(1));

        installBtn = new InstallButton("Installieren", WIDTH/2 - 180/2, HEIGHT-(75+30+10), 180, 30);
        pane.add(installBtn, new Integer(1));

        window.add(pane);
    }
}