package funwithloops;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        // # 1 Loop count down 10 to 1 blastoff
        System.out.print("Count Down ");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(" Blastoff");

        // # 1 loop count down from 10 to 1 blastoff with JOptionPanes
        JOptionPane.showMessageDialog(null, "countdown about to begin");
        for (int i = 10; i > 0; i--) {
            // Make the operating system put this process to sleep for 1 second
            // in a thread that sleeps for 1 second in the background.
            // If the JOption returns before the thread is done sleeping
            // it will still be "alive" so wait until it is not.
            Thread pause = pausethread();
            JOptionPane.showMessageDialog(null, "" + i);
            while (pause.isAlive()) {
                // do nothing
            }
        }
        JOptionPane.showMessageDialog(null, " Blastoff!");

        // ---------------------------------------------------------------------
        // #2 - Ask user for the "secret word" until correct then output num tries
        String guess;
        int tries = 0;
        do {
            guess = JOptionPane.showInputDialog("Enter the secret word: ");
            tries++;
        } while (!guess.equalsIgnoreCase("please"));
        JOptionPane.showMessageDialog(null, "It took " + tries + " guesses");

        // ---------------------------------------------------------------------
        // #3 - Average 10 numbers input from the user
        double sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += Double.parseDouble(JOptionPane.showInputDialog("Enter Number " + i));
        }
        JOptionPane.showMessageDialog(null, "The Average is " + sum / 10);

    }

    // --------------------------------------------------------------------------
    // pause a second and then kill the joptions
    private static Thread pausethread() {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                JOptionPane.getRootFrame().dispose();
            }
        };
        t.start();
        return t;
    }
}
