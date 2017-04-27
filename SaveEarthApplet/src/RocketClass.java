
import java.awt.Polygon;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jack
 */
public class RocketClass {
    double x,y,a;
    Polygon rocketMeth = null;

    //gets INITIAL POSITION ONLY
    public RocketClass(double xrand,double yrand) {
        x = xrand;
        y = yrand;
//        a=...
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
    
    
    //MOVES ROCKET TOWARDS CENTER
    public void moveRocket(int speed) {
//        x=...
//        y=...
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
    
    public Polygon getRocket() {
        return rocketMeth;
    }
    

    public void isClicked() {
        rocketMeth = null;
    }

}
