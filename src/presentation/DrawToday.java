/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Booking;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author simon
 */
public class DrawToday extends JPanel {

    private JPanel panel;
    private final Color blue;
    private final Color green;
    private final Color orange;
    private final Color hoverBlue;
    private final Color hoverGreen;

    private Graphics graphics;

    public DrawToday(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.blue = new Color(0, 153, 204);
        this.green = new Color(112, 186, 52);
        this.orange = new Color(255, 204, 51);
        this.hoverBlue = new Color(0, 127, 178);
        this.hoverGreen = new Color(116, 160, 0);
    }

    @Override
    public void paintComponent(Graphics page) {
        this.setSize(this.panel.getWidth(), this.panel.getHeight());
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;

        Graphics2D graphics2D = (Graphics2D) page;
        //Set  anti-alias!
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Set anti-alias for text
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        ArrayList<Booking[]> list;

        int xSpaceBuffer = width / 20;
        int ySpaceBuffer = 20;
        int boxHeight = 70;
        int boxLength = (width / 2) - xSpaceBuffer;
        int fullBoxlength = width;
        int numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        int xOnePos = 0;
        int xTwoPos = boxLength + (xSpaceBuffer * 2);
        int yBoxPos = 0;

        page.setColor(Color.WHITE);
        page.fillRect(0, 0, width, boxHeight);
        yBoxPos = boxHeight + ySpaceBuffer;

        for (int i = 0; i < numOfRows; ++i) {
            if (i == 1) {
                //page.setColor(blue);
                //page.fillRect(xOnePos, yBoxPos, fullBoxlength, boxHeight);
                addBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight, blue);
            } else if (i == 3) {
                //page.setColor(green);
                //page.fillRect(xOnePos, yBoxPos, fullBoxlength, boxHeight);
                addBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight,green);
            } else {
                //page.setColor(blue);
                addBookingPanel(xOnePos, yBoxPos, boxLength, boxHeight,blue);

                //page.setColor(green);
                addBookingPanel(xTwoPos, yBoxPos, boxLength, boxHeight,green);

            }
            yBoxPos = yBoxPos + ySpaceBuffer + boxHeight;
        }

        page.setColor(Color.black);
        page.setFont(new Font("Arial", 1, 18));
        page.drawString("Guests Today", 10, 35);
        //paintComponentss(this.graphics);
    }

    private void addBookingPanel(int x, int y, int width, int height, Color c) {
        JPanel p = new JPanel();
        this.graphics = p.getGraphics();

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(panel, "DAMN BOY");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                p.setBackground(hoverBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                p.setBackground(blue);
            }

        });
        this.panel.add(p);
        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
        p.setVisible(true);
    }

    public void paintComponentss(Graphics page) {
        page.setColor(Color.black);
        page.drawString("This is my custom Panel!", 5, 5);
    }

}
