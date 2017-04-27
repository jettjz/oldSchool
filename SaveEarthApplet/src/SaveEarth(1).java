/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class SaveEarth extends Applet implements MouseListener {
    boolean isClick=false, GameOver=false;
    int mouseX, mouseY, numRockets, n=0,x,y;
    final int MAX_SCREEN_X=1000, MAX_SCREEN_Y=800;
    ArrayList<RocketClass> polyRocket = new ArrayList();
    Random gen = new Random();
    
    

    public void mouseClicked(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        isClick = true;
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {}

    public void mouseExited(MouseEvent me) {}

    public void init() {
        addMouseListener(this);
        setSize(1000, 800);
    }

    public void paint(Graphics g) {
        while (!GameOver) {
            x = 0;
            y = 0;
            //make x,y location on perimeter
            if (n%5==0) {
            if (gen.nextBoolean()) {
                x = gen.nextInt(MAX_SCREEN_X);
                y = gen.nextInt(2)*800;
            }
            else {
                y = gen.nextInt(MAX_SCREEN_Y);
                x = gen.nextInt(2)*1000;
            }
            RocketClass missile = new RocketClass(x,y);
            g.clearRect(0, 0, 1000, 800);
            g.setColor(Color.BLACK);
            g.fillOval(450, 350, 100, 100);
            polyRocket.add(missile);
            //moves ALL rocekts towards center
            for (int i = 0; i<polyRocket.size(); i++) {
                polyRocket.get(i).moveRocket();
                g.fillPolygon(polyRocket.get(i).getRocket());
            }
            }
            if (isClick) {
                for (int i = 0; i<polyRocket.size(); i++) {
                if (polyRocket.get(i).getRocket().contains(mouseX, mouseY)) {
                polyRocket.remove(i);
                }
            }
            }
            try {
                g.wait(100);
            } catch(InterruptedException e) {}
            n++;
            
            
        }
        
        
    }

    // TODO overwrite start(), stop() and destroy() methods
}
