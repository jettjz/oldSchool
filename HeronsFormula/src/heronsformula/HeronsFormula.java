/*
 * Jack Zhang 
 * Heron's Formula
 */
package heronsformula;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author 16Zhangjt
 */
public class HeronsFormula {

    public static void main(String[] args) {
        double SideA, SideB, SideC, HalfPerimeter, Area;
        
        //asks for inputs to triangle's sides
        SideA = Double.parseDouble(JOptionPane.showInputDialog("Length of side A?"));
        SideB = Double.parseDouble(JOptionPane.showInputDialog("Length of side B?"));
        SideC = Double.parseDouble(JOptionPane.showInputDialog("Length of side C?"));

        //escape sequence in case input does not form a triangle
        while (SideA + SideB <= SideC || SideA + SideC <= SideB || SideB + SideC <= SideA) {
            JOptionPane.showMessageDialog(null, "That's not a triangle ya dunce!");
            SideA = Double.parseDouble(JOptionPane.showInputDialog("Length of side A?"));
            SideB = Double.parseDouble(JOptionPane.showInputDialog("Length of side B?"));
            SideC = Double.parseDouble(JOptionPane.showInputDialog("Length of side C?"));
        }
        
        //find s
        HalfPerimeter = (SideA + SideB + SideC) / 2.0;
        
        //plug into Heron's formula
        Area = Math.sqrt(HalfPerimeter * (HalfPerimeter - SideA) * (HalfPerimeter - SideB) * (HalfPerimeter - SideC));

        //formats decimal to three places
        DecimalFormat f = new DecimalFormat(".###");

        JOptionPane.showMessageDialog(null, "Area: " + f.format(Area), "Heron's Formula", 1);

    }

}
