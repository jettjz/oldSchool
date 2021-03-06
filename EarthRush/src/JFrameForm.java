
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 16Zhangjt
 */
public class JFrameForm extends javax.swing.JFrame implements KeyListener, MouseListener, MouseMotionListener, ActionListener {

    /**
     * Creates new form JFrameForm
     */
    Toolkit tk = Toolkit.getDefaultToolkit();
    //sets width and height to screen size
    private final int WIDTH = (int) tk.getScreenSize().getWidth(), HEIGHT = (int) tk.getScreenSize().getHeight();
    private final int LIVES = 25;
    private Random r = new Random();
    private ArrayList<BadGuyOne> badGuys;
    private int baseX, baseY, numHit = 0, mouseX = 0, mouseY = 0, baseWidth, baseHeight;
    boolean isPause = false;
    Stopwatch sw;
    Timer t;

    public JFrameForm() {
        initComponents();
        badGuys = new ArrayList();
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.setSize(WIDTH, HEIGHT);
        baseWidth = 50;
        baseHeight = 50;
        //puts base in center
        baseX = WIDTH / 2 - baseWidth / 2;
        baseY = HEIGHT / 2 - baseHeight / 2;
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                doaction(ae);
            }
        };
        t = new Timer(10, action);
        sw = new Stopwatch();
        sw.Start();
        t.start();
        //adds first bad guy
        this.addBadGuy();
        this.setTitle("Lives left: " + (LIVES - numHit));
    }

    private void doaction(ActionEvent ae) {
        //adds bad guys if by chance stopwatch shows certain times
        if (sw.getMillis() % 5000 <= 2) {
            addBadGuy();
        }
        //moves all bad guys towards center
        for (BadGuyOne b : badGuys) {
            b.move();
            b.setSpeed(b.getSpeed() + .001);
        }
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameForm().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        this.setTitle("Lives left: " + (LIVES - numHit));
        //pause symbol at top right
        if (isPause) {
            g.setColor(Color.red);
            g.fillRect(WIDTH - 65, 50, 10, 25);
            g.fillRect(WIDTH - 50, 50, 10, 25);
        }
        g.setColor(Color.BLUE);
        g.fillRect(baseX, baseY, baseWidth, baseHeight);
        for (int i = badGuys.size() - 1; i >= 0; i--) {
            //draws bad guys from badGuy array list
            BadGuyOne b = badGuys.get(i);
//            g.fillOval(b.getX(), b.getY(), 10, 10);
            g.setColor(Color.PINK);
            g.fillPolygon(b.getRocket());

            //checks if bad guys hit the base
            if ((b.getX() >= baseX) && (b.getX() <= baseX + baseWidth) && (b.getY() >= baseY) && (b.getY() <= baseY + baseHeight)) {
                badGuys.remove(i);
                numHit++;
                addBadGuy();
                if (numHit >= LIVES) {
                    t.stop();
                    sw.Stop();
                    JOptionPane.showMessageDialog(null, "You deaded\nTime: " + sw.toString());
                }
            } else if ((b.getX() >= mouseX - 20) && (b.getX() <= mouseX + 20) && (b.getY() >= mouseY - 20) && (b.getY() <= mouseY + 20)) {
                badGuys.remove(i);
                addBadGuy();
            }
        }
        g.setColor(Color.RED);
        g.fillOval(mouseX - 20, mouseY - 20, 40, 40);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //this pauses everything in the game
        isPause = !isPause;
        if (isPause) {
            t.stop();
            sw.pause();
        } else {
            t.start();
            sw.unpause();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
        isPause = true;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //the red box follows the mouse
        if (!isPause) {
            mouseX = me.getX();
            mouseY = me.getY();
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    //adds bad guy to random location along edge
    private void addBadGuy() {
        int c = r.nextInt(4);
        if (c == 0) {
            badGuys.add(new BadGuyOne(0, r.nextInt(HEIGHT), baseX + baseWidth / 2, baseY + baseHeight / 2));
        } else if (c == 1) {
            badGuys.add(new BadGuyOne(r.nextInt(WIDTH), 0, baseX + baseWidth / 2, baseY + baseHeight / 2));
        } else if (c == 2) {
            badGuys.add(new BadGuyOne(r.nextInt(WIDTH), HEIGHT, baseX + baseWidth / 2, baseY + baseHeight / 2));
        } else {
            badGuys.add(new BadGuyOne(WIDTH, r.nextInt(HEIGHT), baseX + baseWidth / 2, baseY + baseHeight / 2));
        }
    }
}
