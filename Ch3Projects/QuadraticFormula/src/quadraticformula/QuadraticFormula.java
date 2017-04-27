/*
 * Jack Zhang
 * Quadratic Formula
 */
package quadraticformula;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author 16Zhangjt
 */
public class QuadraticFormula {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "ax^2 + bx + c = 0\n What are the constants?", "QUAD BABY", 1);
        String choice = "y";
        
        // checks if user wants to keep going
        while (choice.compareToIgnoreCase("y") == 0) {

            Double a = Double.parseDouble(JOptionPane.showInputDialog("a = ?"));
            Double b = Double.parseDouble(JOptionPane.showInputDialog("b = ?"));
            Double c = Double.parseDouble(JOptionPane.showInputDialog("c = ?"));

            // calculates the discriminant to determine number of roots
            Double dscrmt = Math.pow(b, 2) - 4 * a * c;

            // calculates root for when a=0
            Double NoA = (-c)/b;

            // calculates roots for when a does not equal 0
            Double root1 = ((-b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
            Double root2 = ((-b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);

            DecimalFormat f = new DecimalFormat("0.###");

            // if-statement takes care of dividing by 0 (when a = 0)
            if (a != 0.0) {
                if (dscrmt > 0) {
                    JOptionPane.showMessageDialog(null, "The roots are " + f.format(root1) + " and " + f.format(root2));
                }

                if (dscrmt == 0) {
                    JOptionPane.showMessageDialog(null, "The only root is " + f.format(root1));
                }

                if (dscrmt < 0) {
                    JOptionPane.showMessageDialog(null, "There are no roots");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "The root is " + f.format(NoA));
            }
            choice = JOptionPane.showInputDialog("Would you like to try again? (y/n)");
        }
    }
}
