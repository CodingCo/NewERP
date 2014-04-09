/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
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

}
