package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon
 */
public class DrawApartment extends JPanel {

    private JPanel panel;
    private final Color blue;
    private final Color green;
    private final Color orange;
    private final Color grey;
    private int cdm;

    private int[] coor;

    public DrawApartment(JPanel panel) {
        this.panel = panel;
        this.setSize(this.panel.getSize());
        this.blue = new Color(0, 153, 204);
        this.green = new Color(119, 204, 51);
        this.orange = new Color(255, 204, 51);
        this.grey = new Color(176, 179, 180);
        this.cdm = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    @Override
    public void paintComponent(Graphics page) {

        int ySpaceBuffer = 5;
        int boxHeight = 60;
        //boxWidth = (width / this.cdm);
        //numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;

        drawCalendarBar(page);

    }

    private void drawBooking(int x, int y, int width, int height, Color c, Color hc, String message) {
        JPanel p = new JPanel();
        JLabel h = new JLabel();
        p.setLayout(new GridLayout(1, 1));

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(panel.getRootPane(), "not yet implemented");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                p.setBackground(hc);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                p.setBackground(c);
            }
        });

        this.panel.add(p);
        p.add(h);

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(message);
        h.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

    private void drawCalendarBar(Graphics page) {
        int size = (this.panel.getWidth() - 1) / this.cdm;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 31; i++) {
            page.setColor(this.grey);
            page.fillRect(x, y, size, (this.panel.getHeight()));
            page.setColor(Color.WHITE);

            page.drawString("" + (i + 1), x + 10, y + 25);
            x = x + size + 1;
        }
    }

    private void calcScreenCoor() {
        int x = 0;
        this.coor = new int[31];
        coor[0] = 0;
        for (int i = 1; i < 31; i++) {
            x = x + ((this.panel.getWidth() - 1) / this.cdm) + 1;
            coor[i] = x;
        }

    }

}
