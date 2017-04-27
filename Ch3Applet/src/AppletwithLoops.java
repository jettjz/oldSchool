/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class AppletwithLoops extends Applet {

    Random gen = new Random();
    int xrand, yrand, c, x1, y1, x2, y2, x3, y3;
    Image img1, img2, img3, img4, img5, img6;
    ArrayList<Image> imageArray = new ArrayList();

    public void init() {
        setSize(1000, 800);
    }

    public void paint(Graphics g) {
        img1 = getImage(getCodeBase(), "SrSink3.png");
        img2 = getImage(getCodeBase(), "Cosenza.png");
        img3 = getImage(getCodeBase(), "Degen.png");
        img4 = getImage(getCodeBase(), "MrForster.png");
        img5 = getImage(getCodeBase(), "Fenstermaker.png");
        img6 = getImage(getCodeBase(), "MrSchwartz.png");
        imageArray.add(img1);
        imageArray.add(img2);
        imageArray.add(img3);
        imageArray.add(img4);
        imageArray.add(img5);
        imageArray.add(img6);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 800);
        for (int n = 1; n <= 19; n++) {
            x1 = 500;
            y1 = 400 - 20 * n;
            x2 = 500 - 20 * n;
            y2 = 400 + 20 * n;
            x3 = 500 + 20 * n;
            y3 = 400 + 20 * n;
            g.setColor(Color.YELLOW);
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x1, y1, x3, y3);
            g.drawLine(x2, y2, x3, y3);
            c = gen.nextInt(6);
            xrand = gen.nextInt(1000);
            yrand = gen.nextInt(800);
            g.drawImage(imageArray.get(c), xrand, yrand, this);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            if (n != 19) {
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2, y2);
                g.drawLine(x1, y1, x3, y3);
                g.drawLine(x2, y2, x3, y3);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        for (int n = 1; n <= 5; n++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(350, 300, 300, 150);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            g.setColor(Color.DARK_GRAY);
            g.fillOval(350, 300, 300, 150);
        }
        g.setColor(Color.BLACK);
        g.fillOval(440, 315, 120, 120);
    }
}
