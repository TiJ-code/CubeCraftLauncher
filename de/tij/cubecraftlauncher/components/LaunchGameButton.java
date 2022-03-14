package de.tij.cubecraftlauncher.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import de.tij.cubecraftlauncher.utils.Vars;

public class LaunchGameButton extends JButton {

    private boolean active = true;

    public LaunchGameButton(String text, int x, int y, int width, int height) {
        super(text);

        Dimension size = new Dimension(width, height);
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setBounds(x, y, width, height);
        setFont(Vars.defaultFont);
        setFocusPainted(false);
        setForeground(Color.WHITE);

        lButtonColor = Vars.LAUNCH_COLOR;

        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isActive()) {
                    super.mouseClicked(e);
                    lButtonColor = Vars.LAUNCH_COLOR.darker();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(isActive()) {
                    super.mouseEntered(e);
                    lButtonColor = Vars.LAUNCH_COLOR.brighter();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(isActive()) {
                    super.mouseExited(e);
                    lButtonColor = Vars.LAUNCH_COLOR;
                }
            }
        });
    }

    private Color lButtonColor;

    @Override
    protected void paintComponent(Graphics g) {
        if(isActive()) {
            g.setColor(lButtonColor);
        } else {
            g.setColor(Color.gray);
        }
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
