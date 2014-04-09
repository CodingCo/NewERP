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
public class Draws extends JPanel {

    public Draws() {

    }

    
    
    
    @Override
    public void paintComponent(Graphics page) {
        page.setColor(Color.black);
        page.drawString("This is my custom Panel!", 5, 5);
    }

}
