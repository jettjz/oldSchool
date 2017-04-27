
package catgame;

import java.awt.Image;
import java.awt.Toolkit;
import javafx.geometry.Rectangle2D;

public class Enemy {

    private int x, y;
    private int width, height;
    private static double speed = 0;
    private Rectangle2D dogRect;
    boolean isSlow = false;
    //gets image of dog
    ClassLoader cloader = Enemy.class.getClassLoader();
    private Image dogImage;

    public Enemy(int xin, int yin, boolean t) {
        //gets image and stuff and sets polygon 
        if (t) {
            isSlow = true;
            width = 107;
            height = 39;
            dogImage = Toolkit.getDefaultToolkit().getImage(cloader.getResource("dog.png"));
        } else {
            width = 68;
            height = 52;
            dogImage = Toolkit.getDefaultToolkit().getImage(cloader.getResource("dog2.png"));
        }
        x = xin;
        y = yin - height;
        dogRect = new Rectangle2D(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

    public static void setSpeed(double d) {
        speed = d;
    }

    public static void addSpeed(double d) {
        speed += d;
    }

    public void move() {
        //adjust the constant speed is multiplied by
        if (isSlow) {
            x -= (5 + (int) (speed * 0.5));
        } else {
            x -= (5 + (int) (speed * 50));
        }
        dogRect = new Rectangle2D(x, y, width, height);
    }

    public Image getImage() {
        return dogImage;
    }

    public Rectangle2D getRect() {
        return dogRect;
    }
}
