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
public class AppletwithLoops extends Applet {

    Random gen = new Random();
    Polygon rocket = new Polygon();
    Polygon rocket2 = new Polygon();
    double x, y, a, x2, y2, a2, r;
    int d=0;
    public void init() {
        setSize(1000, 800);
    }

    public void paint(Graphics g) {
        a = 0;
        r = 400;
        while (d<400) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1000, 800);
//            g.setColor(Color.getHSBColor(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
            x = 500 + r*Math.cos(Math.PI*d/180);
            y = 400 + r*Math.sin(Math.PI*d/180);
            a = Math.atan(-1/Math.tan(Math.PI*d/180));
            x2 = 500 - r*Math.cos(Math.PI*d/180);
            y2 = 400 - r*Math.sin(Math.PI*d/180);
            if (y<400) {
                a = a+Math.PI;
            }
            a = a - Math.PI/2;
            a2 = a + Math.PI;
            makeRocket();
            makeRocket2();
            g.setColor(Color.BLUE);
            g.fillPolygon(rocket);
            g.setColor(Color.BLACK);
            g.fillPolygon(rocket2);
            r = r - 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            d++;
        }
    }

    private void makeRocket() {
        rocket.reset();
        rocket.addPoint((int) (x), (int) (y));
        rocket.addPoint((int) (x + (7) * Math.cos(a) - (10) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (10) * Math.cos(a)));
        rocket.addPoint((int) (x + (7) * Math.cos(a) - (35) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (35) * Math.cos(a)));
        rocket.addPoint((int) (x + (15) * Math.cos(a) - (40) * Math.sin(a)), (int) (y + (15) * Math.sin(a) + (40) * Math.cos(a)));
        rocket.addPoint((int) (x + (15) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (15) * Math.sin(a) + (70) * Math.cos(a)));
        rocket.addPoint((int) (x + (7) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (70) * Math.cos(a)));
        rocket.addPoint((int) (x + (7) * Math.cos(a) - (60) * Math.sin(a)), (int) (y + (7) * Math.sin(a) + (60) * Math.cos(a)));
        rocket.addPoint((int) (x + (-7) * Math.cos(a) - (60) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (60) * Math.cos(a)));
        rocket.addPoint((int) (x + (-7) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (70) * Math.cos(a)));
        rocket.addPoint((int) (x + (-15) * Math.cos(a) - (70) * Math.sin(a)), (int) (y + (-15) * Math.sin(a) + (70) * Math.cos(a)));
        rocket.addPoint((int) (x + (-15) * Math.cos(a) - (40) * Math.sin(a)), (int) (y + (-15) * Math.sin(a) + (40) * Math.cos(a)));
        rocket.addPoint((int) (x + (-7) * Math.cos(a) - (35) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (35) * Math.cos(a)));
        rocket.addPoint((int) (x + (-7) * Math.cos(a) - (10) * Math.sin(a)), (int) (y + (-7) * Math.sin(a) + (10) * Math.cos(a)));
        rocket.addPoint((int) (x), (int) (y));
    }
    private void makeRocket2() {
        rocket2.reset();
        rocket2.addPoint((int) (x2), (int) (y2));
        rocket2.addPoint((int) (x2 + (7) * Math.cos(a2) - (10) * Math.sin(a2)), (int) (y2 + (7) * Math.sin(a2) + (10) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (7) * Math.cos(a2) - (35) * Math.sin(a2)), (int) (y2 + (7) * Math.sin(a2) + (35) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (15) * Math.cos(a2) - (40) * Math.sin(a2)), (int) (y2 + (15) * Math.sin(a2) + (40) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (15) * Math.cos(a2) - (70) * Math.sin(a2)), (int) (y2 + (15) * Math.sin(a2) + (70) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (7) * Math.cos(a2) - (70) * Math.sin(a2)), (int) (y2 + (7) * Math.sin(a2) + (70) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (7) * Math.cos(a2) - (60) * Math.sin(a2)), (int) (y2 + (7) * Math.sin(a2) + (60) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-7) * Math.cos(a2) - (60) * Math.sin(a2)), (int) (y2 + (-7) * Math.sin(a2) + (60) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-7) * Math.cos(a2) - (70) * Math.sin(a2)), (int) (y2 + (-7) * Math.sin(a2) + (70) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-15) * Math.cos(a2) - (70) * Math.sin(a2)), (int) (y2 + (-15) * Math.sin(a2) + (70) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-15) * Math.cos(a2) - (40) * Math.sin(a2)), (int) (y2 + (-15) * Math.sin(a2) + (40) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-7) * Math.cos(a2) - (35) * Math.sin(a2)), (int) (y2 + (-7) * Math.sin(a2) + (35) * Math.cos(a2)));
        rocket2.addPoint((int) (x2 + (-7) * Math.cos(a2) - (10) * Math.sin(a2)), (int) (y2 + (-7) * Math.sin(a2) + (10) * Math.cos(a2)));
        rocket2.addPoint((int) (x2), (int) (y2));
    }
    private Polygon makeRocket(double x, double y, double a) {
        Polygon rocketMeth = new Polygon();
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
        return rocketMeth;
    }
}
