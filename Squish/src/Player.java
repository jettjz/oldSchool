//Jack Zhang
//Player Class


import java.awt.Point;
import java.util.Random;

public class Player implements Comparable {

    private String myName;
    private Point myLocation;
    private int myImage;

    public Player(String name) {
        // constucts a new player with a random location and random image
        Random gen = new Random();
        myName = name;
        myLocation = new Point(gen.nextInt(11), gen.nextInt(11));
        myImage = gen.nextInt(6);
    }

    public Player(String name, int x, int y) {
        // constructs a new player with the given location and random image
        Random gen = new Random();
        myName = name;
        myLocation = new Point(x, y);
        myImage = gen.nextInt(6);
    }

    public Player(String name, int x, int y, int chooseImage) {
        // constructs a new player with the given location and random image
        Random gen = new Random();
        myName = name;
        myLocation = new Point(x, y);
        myImage = chooseImage;
    }

    public Player(String name, int chooseImage) {
        // constucts a new player with a random location and random image
        Random gen = new Random();
        myName = name;
        myLocation = new Point(gen.nextInt(11), gen.nextInt(11));
        myImage = chooseImage;
    }

    public int getX() {
        return myLocation.x;
    }

    public int getY() {
        return myLocation.y;
    }

    public void moveNorth() {
        // moves the player up 1 location if possible
        if (myLocation.y < 10) {
            myLocation.y += 1;
        }
    }

    public void moveSouth() {
        // moves the player down 1 location if possible
        if (myLocation.y > 0) {
            myLocation.y -= 1;
        }
    }

    public void moveEast() {
        // moves the player right 1 location if possible
        if (myLocation.x < 10) {
            myLocation.x += 1;
        }
    }

    public void moveWest() {
        // moves the player left 1 location if possible
        if (myLocation.x > 0) {
            myLocation.x -= 1;
        }
    }

    public void move() {
        //moves a random way
        Random gen = new Random();
        int temp = gen.nextInt(4);
        if (temp == 0) {
            moveNorth();
        } else if (temp == 1) {
            moveSouth();
        } else if (temp == 2) {
            moveEast();
        } else {
            moveWest();
        }
    }
    
    public String getName() {
        return myName;
    }

    public double distance(Player p) {
        // returns the distance between this player and player p
        return (this.myLocation.distance(p.myLocation));
    }

    public boolean isSamelocation(Player p) {
        // returns true if this location is the same a the player p's location
        return ((int) Math.abs(this.distance(p)) == 0);
    }

    public String toString() {
        // returns a string representation of the player location - ex: "(4, 5)"
        return "(" + myLocation.x + ", " + myLocation.y + ")";
    }

    public int compareTo(Object o) {
        // returns a negative number, 0, or a positive number depending if this
        // object is less than, equal to, or greater than the parameter o
        // Players are ordered by x position, then by y position so (2,5) < (3,1)
        Player p = (Player) o;
        if (p.getX() == this.getX()) {
            return p.getY() - this.getY();
        } else {
            return p.getX() - this.getX();
        }
    }
    //returns number of player's image 1-6 for main class's image retrieval
    public int getImage() {
        return myImage+1;
    }
    //changes name
    public void changeName(String s) {
        myName = s;
    }
    //changes x
    public void changeX(int x) {
        if (x>10) {
            myLocation.x = 10;
        } else if (x<0) {
            myLocation.x = 0;
        } else {
            myLocation.x = x;
        }
    }
    //changes y
    public void changeY(int y) {
        if (y>10) {
            myLocation.y = 10;
        } else if (y<0) {
            myLocation.y = 0;
        } else {
            myLocation.y = y;
        }
    }
    //changes image number
    public void changeImage(int c) {
        myImage = c;
    }

}
