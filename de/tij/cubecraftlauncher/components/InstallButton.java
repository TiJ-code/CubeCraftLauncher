package de.tij.cubecraftlauncher.components;

import de.tij.cubecraftlauncher.utils.Vars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstallButton extends JButton {

    private Color lButtonColor;

    public InstallButton(String text, int x, int y, int width, int height) {
        super(text);

        Dimension size = new Dimension(width, height);
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setBounds(x, y, width, height);
        setFont(Vars.defaultFont);
        setFocusPainted(false);
        setForeground(Color.WHITE);

        lButtonColor = Vars.INSTALL_COLOR;

        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lButtonColor = Vars.INSTALL_COLOR.darker();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lButtonColor = Vars.INSTALL_COLOR.brighter();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lButtonColor = Vars.INSTALL_COLOR;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(lButtonColor);
        g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, 20,20);
        super.paintComponent(g);
        repaint();
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0,0,getSize().width-1,getSize().height-1, 20, 20);
        repaint();
    }
}
