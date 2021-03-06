package presentation;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author simon
 */
public class LaunchProgram {

    public static void main(String[] args) {

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
        setLookAndFeel();
        CasablancaGUI g = new CasablancaGUI(devices[0]);
        
    }

    private static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (IllegalAccessException ex) {
        } catch (InstantiationException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }
}
