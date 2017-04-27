/*
 * Jack Zhang
 * Grade Calculator
 */

package testscore;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author 16Zhangjt
 */
public class TestScore {

    public static void main(String[] args) {
        double scored, total, percent;
        String choice = "y";
        
        // checks if user wants to keep going
        while (choice.compareToIgnoreCase("y") == 0) {
            scored = Double.parseDouble(JOptionPane.showInputDialog("Enter points scored on the test"));
            total = Double.parseDouble(JOptionPane.showInputDialog("Enter total points on the test"));

            percent = 100*(scored/total);
            DecimalFormat f = new DecimalFormat("0.#");

            // tests grades for score
            if (percent == 100) {
                JOptionPane.showMessageDialog(null, "You aced the test!", "STOP TRYING SO HARD!", 1);
                JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "\nGrade: A+", "BLAH BLAH BLAH", 1);
            }

            else if (percent >=90) {
                JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "\nGrade: A");
            }

            else if (percent >=80) {
                JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "\nGrade: B");
            }

            else if (percent >=70) {
                JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "\nGrade: C");
            }

            else if (percent >=60) {
                JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "\nGrade: D");
            }

            else {
               JOptionPane.showMessageDialog(null, "Score: " + f.format(percent) + "%"+ "\nGrade: F");
               JOptionPane.showMessageDialog(null, "YOU FAILED GAAAHHHH!!!!");
            }
            choice = JOptionPane.showInputDialog("Would you like to try again? (y/n)");
        }
    }
}
