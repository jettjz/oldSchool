
import java.awt.Color;
import java.awt.Polygon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 16Zhangjt
 */
public class BadGuyOne {

    private static int numBadGuyOnes = 0;
    private int x, y, health, centerX, centerY, length;
    private double speed;
    private Polygon rocket;
    double angle;

    public BadGuyOne(int xin, int yin, int cx, int cy) {
//        shape = createPolygon(xin, yin);
        rocket = new Polygon();
        x = xin;
        y = yin;
        centerX = cx;
        centerY = cy;
        numBadGuyOnes++;
        speed = 0;
        angle = Math.atan((double) (cy - y) / (double) (cx - x)) + Math.PI / 2;
        if ((cx - x) < 0) {
            angle += Math.PI;
        }
        makeRocket(x, y, angle);
    }
//
//    private Polygon createPolygon(int xin, int yin) {
//        Polygon s = new Polygon();
//        s.addPoint(xin, yin);
//        return s;
//    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double d) {
        speed = d;
    }

    public void move() {
        x += (int) (speed * (centerX - x));
        y += (int) (speed * (centerY - y));
        makeRocket(x, y, angle);
    }
    
    public Polygon getRocket() {
        return rocket;
    }

    private void makeRocket(int x, int y, double a) {
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

}
