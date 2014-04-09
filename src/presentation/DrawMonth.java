/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author simon
 */
public class DrawMonth extends JPanel {

    private JPanel panel;
    private final Color red;
    private final Color green;
    private final Color grey;

    public DrawMonth(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.red = new Color(204, 0, 0);
        this.green = new Color(102, 153, 0);
        this.grey = new Color(153, 153, 153);
    }

    @Override
    public void paintComponent(Graphics page) {
        Graphics2D graphics2D = (Graphics2D) page;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        drawCalendarBar(page);

        int width = this.panel.getWidth() - 1;
        int rSize = width / 31;
        int xPos = 3;
        int yPos = 2;

        int[] coor = new int[31];
        coor[0] = 3;
        for (int i = 1; i < 31; i++) {
            
            if (i % 2 == 0) {
                xPos = xPos + rSize + 1;
                coor[i] = xPos;
            } else {
                xPos = xPos + rSize;
                coor[i] = xPos;
            }
        }
        
        
        page.fillRect(coor[0], 200, rSize, 40);
        

    }

    private void drawCalendarBar(Graphics page) {
        int width = this.panel.getWidth() - 1;
        int rSize = width / 31;
        int xPos = 3;
        int yPos = 2;

        for (int i = 0; i < 31; i++) {
            page.setColor(Color.GRAY);
            page.fillRect(xPos, yPos, rSize - 2, 40);
            page.setColor(Color.WHITE);
            page.drawString("" + (i + 1), xPos + 5, yPos + 20);
            if (i % 2 == 0) {
                xPos = xPos + rSize + 1;
            } else {
                xPos = xPos + rSize;
            }
        }
    }
}
