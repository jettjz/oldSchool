/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitedpassword;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author 16Zhangjt
 */
public class LimitedPassword {

    private void RandMessageLocation(int x, int y) {
        JOptionPane message = new JOptionPane("ERROR 507", JOptionPane.WARNING_MESSAGE);
        JDialog dialog = message.createDialog(null, "FORSTER ANTI_VIRUS");
        dialog.setLocation(x, y);
        dialog.setModal(false);
        dialog.setVisible(true);
    }

    public ImageIcon createImageIcon(String path, String description) {
        URL imageURL = getClass().getResource(path);
        return new ImageIcon(imageURL, description);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        LimitedPassword lp = new LimitedPassword();
        ImageIcon SrSink = lp.createImageIcon("resources/ScottKelticKnot.jpg", "Our Savior");
        Random gen = new Random();
        final String PASSWORD = "APCS turns me O(N)!";
        String input;
        int count = 2;
        do {
            input = JOptionPane.showInputDialog("What is the password?\nNumber of tries left: " + count);
            count--;
        } while ((!input.equals(PASSWORD) && count >= 1));
        if (input.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(null, "You may pass...");
        } else {

            for (int i = 40; i >= 1; i--) {
                Thread pause = pausethread(50);
                JOptionPane.showMessageDialog(null, "ERROR: Attempted breach in program\nInitializing Error Code 9", "Forster AntiVirus", JOptionPane.ERROR_MESSAGE);
                while (pause.isAlive()) {
                }
            }

            for (int i = 10; i >= 1; i--) {
                Thread pause = pausethread(1000);
                JOptionPane.showMessageDialog(null, "Time remaining: " + i, "ERROR", JOptionPane.ERROR_MESSAGE);
                while (pause.isAlive()) {
                }
            }
            for (int i = 0; i <= 20; i++) {
                Thread pause = pausethread((long) (Math.random() * 1000));
                JOptionPane.showMessageDialog(null, "ERASING HARD DRIVE:\nPercent Completed: " + i * 5 + "%", "ERROR CODE 9", JOptionPane.ERROR_MESSAGE);
                while (pause.isAlive()) {
                }
            }
//            Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
            //brings up image of our savior
            for (int i = 0; i < 250; i++) {
                lp.RandMessageLocation(gen.nextInt(width), gen.nextInt(height));
            }
            JOptionPane.showMessageDialog(null, "BREAK THE BANK!!!", "QUEEEEEE BBUUUUUUEEEEENNNOOO!!!!!", JOptionPane.INFORMATION_MESSAGE, SrSink);
            System.exit(1);

        }

    }

    private static Thread pausethread(long time) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }
                JOptionPane.getRootFrame().dispose();
            }
        };
        t.start();
        return t;
    }

}
