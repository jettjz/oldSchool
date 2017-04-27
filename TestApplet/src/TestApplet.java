/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

/**
 *
 * @author Jack
 */
public class TestApplet extends Applet {

    double x, y, m, a;
    Polygon rocketMeth = new Polygon();
    Random gen = new Random();

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        setSize(1000, 800);
    }

    public void paint(Graphics g) {
        if (gen.nextBoolean()) {
            x = gen.nextInt(1000);
            y = gen.nextInt(2) * 800;
        } else {
            y = gen.nextInt(800);
            x = gen.nextInt(2) * 1000;
        }
        m = (y - 400) / (x - 500);
        a = Math.atan(m) + Math.PI / 2;
        g.setColor(Color.RED);
        for (int i = 0; i < 50; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1000, 800);
            moveRocket();
            g.setColor(Color.RED);
            g.fillPolygon(rocketMeth);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void moveRocket() {
        if (x > 500) {
            x = x - 5;
        } else {
            x = x + 5;
        }
        if (y < 400) {
            y = 5 * m + y;
        } else {
            y = y - 5 * m;
        }
        rocketMeth.reset();
        rocketMeth.addPoint((int) (x), (int) (y));
        rocketMeth.addPoint((int) (x + (7) * Math.cos(a) - (10) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (10) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (7) * Math.cos(a) - (35) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (35) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (15) * Math.cos(a) - (40) * Math.sin(a)), (int) (y + (15) * Math.sin(a) + (40) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (15) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (15) * Math.sin(a) + (70) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (7) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (70) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (7) * Math.cos(a) - (60) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (60) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-7) * Math.cos(a) - (60) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (60) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-7) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (70) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-15) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (-15) * Math.sin(a) + (70) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-15) * Math.cos(a) - (40) * Math.sin(a)), (int) (y + (-15) * Math.sin(a) + (40) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-7) * Math.cos(a) - (35) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (35) * Math.cos(a)));
        rocketMeth.addPoint((int) (x + (-7) * Math.cos(a) - (10) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (10) * Math.cos(a)));
        rocketMeth.addPoint((int) (x), (int) (y));
    }

    // TODO overwrite start(), stop() and destroy() methods
}
