package de.tij.cubecraftlauncher.components;

import de.tij.cubecraftlauncher.gui.GUI;
import de.tij.cubecraftlauncher.utils.Vars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitlebarButton extends JButton {

    public TitlebarButton(String text, int x, int y, int width, int height) {
        setText(text);
        setBounds(x,y,width,height);
        setBackground(Vars.BUTTON_TITLEBAR.darker());
        setForeground(Vars.BUTTON_TITLEBAR_TEXT);
        setFont(Vars.defaultFont);
        setBorder(null);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(Vars.BUTTON_TITLEBAR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(Vars.BUTTON_TITLEBAR.darker());
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setBackground(Vars.BUTTON_TITLEBAR.brighter());
            }
        });
    }
}
