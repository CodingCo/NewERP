/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author simon
 */
public class DrawMonth extends JPanel {

    private JPanel panel;
    private final Color blue;
    private final Color green;
    private final Color orange;
    private int pointer;
    private int month;
    private int[] coor;
    private ArrayList<int[]> list;

    public DrawMonth(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.blue = new Color(0, 153, 204);
        this.green = new Color(119, 204, 51);
        this.orange = new Color(255, 204, 51);
        this.list = new ArrayList();
        this.coor = new int[31];
        this.pointer = 0;
    }

    public void initializeListAndMonth(ArrayList<int[]> list, String date) {
        this.list = list;
        try {
            month = Integer.parseInt(date.substring(3, 5));
        } catch (NumberFormatException ex) {

        }
    }

    @Override
    public void paintComponent(Graphics page) {
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        int ySpaceBuffer = 5;
        int boxHeight = 60;
        int boxLength = width / 31;
        int numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        /////// draw
        drawCalendarBar(page);
        calcScreenCoor();
        ///////
        
        int size = (width / 31);
        int x = 0;
        int y = boxHeight + ySpaceBuffer;
        
        
        
        
        
        int rIndex = pointer;
        int index = 1 + pointer;
        int aSize = list.size();
        int to = (aSize - (aSize - (numOfRows * index)));
        int from = numOfRows * rIndex;
        if (to > list.size()) {
            to = list.size();
        }
        
        
        
        
        for (int g = 0; g < numOfRows; ++g) {

            if (g == 1) {

                page.fillRect(coor[0], y, ((size) * 3), boxHeight);
                page.fillRect(coor[3], y, ((size) * 5) + 4, boxHeight);
                page.fillRect(coor[10], y, (size) * 3, boxHeight);
                page.fillRect(coor[13], y, (size) * 8, boxHeight);

            } else {
                for (int m = 0; m < 31; ++m) {
                    page.fillRect(coor[m], y, size, boxHeight);
                }
            }

            y = y + boxHeight + ySpaceBuffer;
        }
    }

    private void drawCalendarBar(Graphics page) {
        int size = (this.panel.getWidth() - 1) / 31;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 31; i++) {
            page.setColor(Color.GRAY);
            page.fillRect(x, y, size, 60);
            page.setColor(Color.WHITE);
            page.drawString("" + (i + 1), x + 5, y + 20);
            x = x + size + 1;
        }
    }

    private void calcScreenCoor() {
        int x = 0;
        this.coor = new int[31];
        coor[0] = 0;
        for (int i = 1; i < 31; i++) {
            x = x + ((this.panel.getWidth() - 1) / 31) + 1;
            coor[i] = x;
        }

    }

}
