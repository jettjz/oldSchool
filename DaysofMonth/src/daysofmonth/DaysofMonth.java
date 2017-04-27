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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int month, year;
        boolean leap = false;
        String months[] = {"January", "February", "March", "April", "May", 
            "June", "July", "August", "September", "October", "November", "December"};
        
        month = Integer.parseInt(JOptionPane.showInputDialog("What number month is it?"));
        year = Integer.parseInt(JOptionPane.showInputDialog("What year is it?"));
        
        //tests to see if year is a leap year or not
        if ((year%4) == 0) {
            if ((year%100) == 0) {
                if ((year%400) == 0) {
                    leap = true;
                    System.out.println("leap");
                }
                else {
                    leap = false;
                }
            }
            else {
                leap = true;
            }
        }
        else {
            leap = false;
        }
        
        //make sure it is actually a month
        if (month < 13) {
            //February gets own case
            if (month == 2) {
                if (leap) {
                    JOptionPane.showMessageDialog(null, "LEAP YEAR!!!!\n" + months[month-1] + " has 29 days in " + year);
                }
                else {
                    JOptionPane.showMessageDialog(null, months[month-1] + " has 28 days in " + year);
                }
            }
            //even months have 30 days...odds have 31
            else if (month%2 == 0) {
                JOptionPane.showMessageDialog(null, months[month-1] + " has 30 days in " + year);
            }
            else {
                JOptionPane.showMessageDialog(null, months[month-1] + " has 31 days in " + year);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Month number " + month + " does not exist.");
        }
    } 
}
