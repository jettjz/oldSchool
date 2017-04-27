/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Jack
 */
public class SaveEarth extends Applet implements MouseListener {
    boolean mouseEntered, GameOver=false;
    int mouseX, mouseY, numRockets, n=0,x,y;
    ArrayList<RocketClass> polyRocket = new ArrayList();
    
    

    public void mouseClicked(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        // Will draw the "inside applet message" 
        mouseEntered = true;
    }

    public void mouseExited(MouseEvent me) {
        // will draw the "outside applet message" 
        mouseEntered = false;
    }

    public void init() {
        addMouseListener(this);
        setSize(1000, 800);
    }

    public void paint(Graphics g) {
        while (!GameOver) {
            //make x and y random later
            RocketClass missile = new RocketClass(x,y);
            g.clearRect(0, 0, 1000, 800);
            g.setColor(Color.BLACK);
            g.fillOval(450, 350, 100, 100);
            polyRocket.add(missile);
            //moves ALL rocekts towards center
            for (int i = 0; i<polyRocket.size(); i++) {
                polyRocket.get(i).moveRocket(i);
                g.fillPolygon(polyRocket.get(i).getRocket());
            }
            try {
                g.wait(100);
            } catch(InterruptedException e) {}
            
        }
        
        
    }

    // TODO overwrite start(), stop() and destroy() methods
}
