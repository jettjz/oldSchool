/*
Jack Zhang's
Time Conversions
 */

package testgame;

import javax.swing.JOptionPane;

/**
 *
 * @author 16Zhangjt
 */
public class TestGame {

    public static void main(String[] args) {
        
        int min, hour, sec, in;
        //inputs total seconds and converts that to an integer
        in = Integer.parseInt(JOptionPane.showInputDialog("How many total seconds?"));
        
        //carries out calculations taking advantage of integer math
        hour = in/3600;       
        min = (in%3600)/60;                       
        sec = (in%3600)%60;
        
        //displays time in HH:MM:SS format
        JOptionPane.showMessageDialog(null, in + " seconds is...\n" + hour/10 + 
                hour%10 + ":" + min/10 + min%10 + ":" + sec/10 + sec%10 + "!");
        
    }
    
}
