/*
 * Jack Zhang
 * Applet Picture
 */


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jack
 */
public class Picture extends Applet {

    public void paint(Graphics g) {
        

        //orange crown
        int x1[] = {100, 350, 600, 350, 100};
        int y1[] = {100, 200, 100, 300, 100};

        //grey mask
        int x2[] = {150, 350, 550, 500, 350, 200, 150};
        int y2[] = {125, 250, 125, 450, 550, 450, 125};

        //red eye slot
        int x3[] = {200, 350, 500, 475, 350, 225, 200};
        int y3[] = {250, 300, 250, 265, 375, 265, 250};


        g.setColor(Color.GRAY);
        g.fillPolygon(x2, y2, 7);

        g.setColor(Color.orange);
        g.fillPolygon(x1, y1, 5);

        g.setColor(Color.red);
        g.fillPolygon(x3, y3, 7);

        //mouth holes
        g.setColor(Color.DARK_GRAY);
        g.fillRect(340, 420, 20, 80);
        g.fillRect(300, 420, 20, 50);
        g.fillRect(380, 420, 20, 50);
        g.fillRect(260, 410, 20, 35);
        g.fillRect(420, 410, 20, 35);
        
        //robot main head
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(800, 200, 400, 350);
        
        //antennae
        g.setColor(Color.DARK_GRAY);
        g.drawLine(1010, 200, 1100, 100);
        g.drawLine(990 , 200, 870 , 120);
               
        //Mouth black outline
        g.setColor(Color.BLACK);
        g.fillOval(900, 400, 200, 100);
        
        //Mouth White inside
        g.setColor(Color.WHITE);
        g.fillOval(920, 420, 160, 60);
        
        //Teeth in Mouth
        g.setColor(Color.BLACK);
        g.drawLine(1000, 420, 1000, 480);
        g.drawLine(1050, 420, 1050, 480);
        g.drawLine(950 , 420, 950 , 480);
        g.drawLine(900 , 450, 1100, 450);
        
        //Eyes
        g.setColor(Color.CYAN);
        g.fillOval(875, 250, 50, 80);
        g.fillOval(1075, 250, 50, 80);
        
        //pupils
        g.setColor(Color.DARK_GRAY);
        g.fillOval(885 , 260, 30, 30);
        g.fillOval(1085, 300, 30, 30);
        
        
        
    }

    // TODO overwrite start(), stop() and destroy() methods
}
