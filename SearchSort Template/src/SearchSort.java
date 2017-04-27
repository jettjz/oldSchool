
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/*
 * Jack Zhang
 * 2/6/2015
 */
public class SearchSort {

    // **************** Main Code to manipulate the SSList
    public static void main(String[] args) {
        // Change the font to be fixed in size for JOptions
        // Some Mono-Spaced fonts include: Miriam Fixed, Courier, 
        boolean isSorted = false;
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier", Font.PLAIN, 14)));
        int defaultOption = 1;

        SSList s = new SSList();

        String[] options = {"Empty List", "Random List", "Add a Word", "Display the List", "Linear Search", 
            "Binary Search", "Insertion Sort", "Bubble Sort", "Selection Sort", "Write to Text File", 
            "Read from File", "Exit"};
        String option;

        do {
            option = (String) JOptionPane.showInputDialog(null, "Enter Menu Option",
                    "Search and Sort", JOptionPane.PLAIN_MESSAGE, null, options, options[defaultOption]);
            if (option.equals(options[0])) {
                // Creates an Empty List
                s = new SSList();
                isSorted = false;
                defaultOption = 1;
            } else if (option.equals(options[1])) {
                // Create Random List
                s = new SSList(Integer.parseInt(JOptionPane.showInputDialog("How many words?")));
                isSorted = false;
                defaultOption = 6;
            } else if (option.equals(options[2])) {
                // Adds a word to the list
                s.add(JOptionPane.showInputDialog("Enter a word to add"));
                isSorted = false;
                defaultOption = 6;
            } else if (option.equals(options[3])) {
                // Displays the list (calls sslist method)
                // You might want to use JOptionPanes for small lists and SOUTS for bigger lists
                if (s.size() < 101) {
                    JOptionPane.showMessageDialog(null, s);
                } else {
                    System.out.println(s);
                }
                defaultOption = 4;
            } else if (option.equals(options[4])) {
                // Search for a word (unordered search)
                String search = JOptionPane.showInputDialog("Search for a word");
                int index = s.LinearSearch(search);
                if (index != -1) {
                    JOptionPane.showMessageDialog(null, search + " is located at index number " + index);
                } else {
                    JOptionPane.showMessageDialog(null, search + " is not in the list");
                }
                defaultOption = 5;
            } else if (option.equals(options[5])) {
                // Search for a word (ordered search)
                if (isSorted) {
                    String search = JOptionPane.showInputDialog("Search for a word");
                    int index = s.LinearSearch(search);
                    if (index != -1) {
                        JOptionPane.showMessageDialog(null, search + " is located at index number " + index);
                    } else {
                        JOptionPane.showMessageDialog(null, search + " is not in the list");
                    }
                    defaultOption = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: not sorted");
                    defaultOption = 6;
                }
            } else if (option.equals(options[6])) {
                //Insertion Sort + time
                Stopwatch t = new Stopwatch();
                t.Start();
                s.InsertionSort();
                t.Stop();
                JOptionPane.showMessageDialog(null, "Insertion Sort time to complete: " + t);
                isSorted = true;
                defaultOption = 3;
            } else if (option.equals(options[7])) {
                //Bubble Sort + time
                Stopwatch t = new Stopwatch();
                t.Start();
                s.BubbleSort();
                t.Stop();
                JOptionPane.showMessageDialog(null, "Bubble Sort time to complete: " + t);
                isSorted = true;
                defaultOption = 3;
            } else if (option.equals(options[8])) {
                //Selection Sort + time
                Stopwatch t = new Stopwatch();
                t.Start();
                s.SelectionSort();
                t.Stop();
                JOptionPane.showMessageDialog(null, "Selection Sort time to complete: " + t);
                isSorted = true;
                defaultOption = 3;
            } else if (option.equals(options[9])) {
                //write to disk
                s.WriteToDisk(JOptionPane.showInputDialog("Enter name of file (add .txt to create a text file):"));
                defaultOption = 0;
            } else if (option.equals(options[10])) {
                //read from file
                s.ReadFromDisk(JOptionPane.showInputDialog("What is the name of the file you would like to read?:"));
                isSorted = false;
                defaultOption = 3;
            }

        } while (!option.equals(options[11]));
        JOptionPane.showMessageDialog(null, "Thanks and come again");
    }
}
