//Jack Zhang
//Squish Main

import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Squish {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Squish by Jack Zhang");

        int choice, numWins = 0, numLoss = 0;
        boolean isWin = false;
        DecimalFormat fmt = new DecimalFormat("0.###");
        Player user = new Player("Bob");
        String[] options = {"Play!", "Change Name", "Change Image", "Set Starting Location"};
        Stopwatch t = new Stopwatch();
        
        //start stopwatch
        t.Start();
        do {
            //option menu before game to edit character
            do {
                choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
                //changes name with changeName method
                if (choice == 1) {
                    String temp = JOptionPane.showInputDialog("What is your new name?", "Current Name: " + user.getName());
                    user.changeName(temp);
                } else if (choice == 2) {
                    //changes image
                    String[] charOptions = {"Sr. Sink", "Sr. Cosenza", "Degen", "Fenstermaker", "Forster", "Schwartzberg"};
                    int charchoice = JOptionPane.showOptionDialog(null, "Who do you want to be?", "You are currently " + charOptions[user.getImage() - 1], JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, charOptions, 0);
                    user.changeImage(charchoice);
                } else if (choice == 3) {
                    //changes starting position making sure it is within 0-10
                    int tempX, tempY;
                    tempX = Integer.parseInt(JOptionPane.showInputDialog(null, "What is you new X position?", "Current position: " + user, JOptionPane.PLAIN_MESSAGE));
                    user.changeX(tempX);
                    tempY = Integer.parseInt(JOptionPane.showInputDialog(null, "What is you new Y position?", "Current position: " + user, JOptionPane.PLAIN_MESSAGE));
                    user.changeY(tempY);
                }
            } while (choice != 0);
            //creates enemy player while not equal to users player
            Player enemy;
            do {
                enemy = new Player("evildude");
            } while ((enemy.isSamelocation(user)));
            String[] nsewoptions = {"North", "South", "East", "West"};
            //shows board and asks user for direction
            while (!user.isSamelocation(enemy)) {
                choice = JOptionPane.showOptionDialog(null, getPanel("   Distance from enemy " + fmt.format(user.distance(enemy)), user), "Player " + user.getName() + " is at " + user, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, nsewoptions, 0);
                if (choice == 0) {
                    user.moveNorth();
                } else if (choice == 1) {
                    user.moveSouth();
                } else if (choice == 2) {
                    user.moveEast();
                } else if (choice == 3) {
                    user.moveWest();
                }
                //tests if user is in same location before enemy moves and sets isWin to be true and breaks while loop or otherwise moves the enemy randomly
                if (user.isSamelocation(enemy)) {
                    isWin = true;
                    break;
                } else {
                    enemy.move();
                }
            }
            //win or lose display
            if (isWin) {
                JOptionPane.showMessageDialog(null, "Wow you won yay good for you");
                numWins++;
            } else {
                JOptionPane.showMessageDialog(null, "sux you lost lol");
                numLoss++;
            }
            JOptionPane.showMessageDialog(null, "Wins: " + numWins + "\nLosses: " + numLoss);
        } while (JOptionPane.showConfirmDialog(null, "Play Again?", null, JOptionPane.YES_NO_OPTION) == 0);
        t.Stop();
        JOptionPane.showMessageDialog(null, "Time Playing:\n" + t);
    }

    //creates image of the player in panel which can be put inside of JOptionPanes
    public static JPanel getPanel(String s, Player p) {
        ClassLoader cloader = Squish.class.getClassLoader();
        JPanel panel = new JPanel();
        JLabel l1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(cloader.getResource("gameBoard.png"))));
        //this gets an image 1-6.png of a teacher to be the player's image
        JLabel l2 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(cloader.getResource(p.getImage() + ".png"))));
        //sets location on grid
        l2.setLocation(5 + (60 * p.getX()), 605 - (60 * p.getY()));
        l2.setSize(50, 50);
        JLabel message = new JLabel(s);
        l1.add(l2);
        panel.add(l1);
        panel.add(message);
        return panel;
    }

}
