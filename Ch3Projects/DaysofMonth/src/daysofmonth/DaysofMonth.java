/*
 * Jack Zhang
 * Leap Year and number of days in month
 */
package daysofmonth;

import javax.swing.JOptionPane;

/**
 *
 * @author 16Zhangjt
 */
public class DaysofMonth {

    public static void main(String[] args) {
        int month, year;
        boolean leap = false;
        String months[] = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        String choice = "y";
        
        // checks if user wants to keep going
        while (choice.compareToIgnoreCase("y") == 0) {
            month = Integer.parseInt(JOptionPane.showInputDialog("What number month is it? (1-12)"));
            year = Integer.parseInt(JOptionPane.showInputDialog("What year is it?"));

            if ((year % 4 == 0) && !((year % 100 == 0) && !(year % 400 == 0))) {
                leap = true;
            } 
            else {
                leap = false;
            }

            //make sure it is actually a month
            if ((month < 13) && (month > 0)) {
                //February gets own case
                if (month == 2) {
                    if (leap) {
                        JOptionPane.showMessageDialog(null, "LEAP YEAR!!!!\n" + months[month - 1] + " has 29 days in " + year);
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, months[month - 1] + " has 28 days in " + year);
                    }
                } 
                //even months have 30 days...odds have 31
                else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    JOptionPane.showMessageDialog(null, months[month - 1] + " has 30 days in " + year);
                } 
                else {
                    JOptionPane.showMessageDialog(null, months[month - 1] + " has 31 days in " + year);
                }
            } 
            else {
                JOptionPane.showMessageDialog(null, "Month number " + month + " does not exist.");
            }
            //tests if user wants to play again
            choice = JOptionPane.showInputDialog("Would you like to try again? (y/n)");
        }
        JOptionPane.showMessageDialog(null, "Ok, FINE!\nLeave and get out of my face!!!");
    }
}
