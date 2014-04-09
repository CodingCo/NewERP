/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author simon
 */
public class DrawApartment extends JPanel {

    private JPanel panel;
    private final Color red;
    private final Color green;
    private final Color grey;

    public DrawApartment(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.red = new Color(204, 0, 0);
        this.green = new Color(102, 153, 0);
        this.grey = new Color(153, 153, 153);
    }

    @Override
    public void paintComponent(Graphics page) {
        
        
        
        
    }
}
