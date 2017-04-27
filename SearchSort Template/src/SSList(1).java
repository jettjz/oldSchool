/*
 * Jack Zhang
 * 2/6/2015
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SSList {
    //-------------------- Private GLOBAL Data -----------------

    private String[] myList;
    private final int WORDSIZE = 5;

    //-------------------- Constructors ------------------------
    public SSList() {
        // Creates an empty list
        myList = new String[0];
    }

    public SSList(int n) {
        // Creates a list of n random words of length WORDSIZE
        // -- Call createword(int) to create the words
        myList = new String[n];
        for (int i = 0; i < myList.length; i++) {
            myList[i] = CreateWord(WORDSIZE);
        }
    }

    //-------------------- Public Methods-----------------------
    public int size() {
        // returns the size of the list
        return myList.length;
    }

    public void add(String s) {
        // Adds an element to the list by increasing the size of the list
        // by one, copying all the elements over, and adding s
        String[] temp = new String[myList.length + 1];
        for (int i = 0; i < myList.length; i++) {
            temp[i] = myList[i];
        }
        temp[myList.length] = s;
        myList = temp;
    }

    public String get(int i) {
        // Returns the string at index i or "" if i is invalid
        if (myList[i] == null) {
            return "";
        } else {
            return myList[i];
        }
    }

    public String toString() {
        // Returns a string representation of the list in a nice columned
        // chart to be used by System.out.println()
        String s = "";
        final int COL = 16;
        for (int i = 1; i <= myList.length; i++) {
            String tmp = " " + myList[i - 1];
            while (tmp.length() <= 4) {
                tmp = " " + tmp;
            }
            s += tmp;
            if (i % COL == 0) {
                s += "\n";
            }
        }
        return s;
    }

// -----------------------------------------------------------------------------
    public int LinearSearch(String s) {
        // Searches for s in the list and returns the index or -1
        // Remember that you cannot use == with strings since they are objects
        // - you need to use .equals() or .compareTo()
        for (int i = 0; i < myList.length; i++) {
            if (myList[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public int BinarySearch(String s) {
        // Searches for s in a Sorted list and returns the index or -1
        // Remember that you cannot use == with strings since they are objects
        // - you need to use .equals() or .compareTo()
        int low = 0;
        int high = myList.length - 1;
        int test = -1;
        do {
            test = (high + low) / 2;
            if (myList[test].compareTo(s) < 0) {
                low = test + 1;
            } else if (myList[test].compareTo(s) > 0) {
                high = test - 1;
            } else {
                return test;
            }
        } while (high >= low);
        return -1;
    }
// -----------------------------------------------------------------------------

    public void BubbleSort() {
        // Sorts the list using the Bubble Sort algorithm
        // Remember that you cannot use == with strings since they are objects
        // - you need to use .equals() or .compareTo()
        int last = myList.length - 1;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < last; i++) {
                if (myList[i].compareTo(myList[i + 1]) > 0) {
                    Swap(i, i + 1);
                    swapped = true;
                }
            }
            last--;
        } while (swapped);
    }
// -----------------------------------------------------------------------------

    public void InsertionSort() {
        // Sorts the list using the Insertion Sort algorithm
        // Remember that you cannot use == with strings since they are objects
        // - you need to use .equals() or .compareTo()
        //
        // This should call the private insert() method below
        for (int i = 1; i < myList.length; i++) {
            Insert(myList[i], i - 1);
        }
    }

    private void Insert(String w, int last) {
        // This will insert the string v into myList in the already sorted
        // top of the list from 0 to last. There should not be a call to swap
        // Used by InsertionSort()
        while ((last >= 0) && (myList[last].compareTo(w) > 0)) {
            myList[last + 1] = myList[last];
            last--;
        }
        myList[last + 1] = w;
    }
// -----------------------------------------------------------------------------

    public void SelectionSort() {
        // Sorts the list using the Selection Sort algorithm
        // Remember that you cannot use == with strings since they are objects
        // - you need to use .equals() or .compareTo()
        //
        // This should call the private Smallest method below
        for (int i = 0; i < myList.length; i++) {
            Swap(i, Smallest(i));
        }
    }

    private int Smallest(int start) {
        // find the index of the smallest value in myList between start and the
        // end of myList. Used by SelectionSort()
        String small = myList[start];
        int index = start;
        for (int i = start; i < myList.length; i++) {
            if (myList[i].compareTo(small) < 0) {
                small = myList[i];
                index = i;
            }
        }
        return index;
    }
// -----------------------------------------------------------------------------

    public boolean ReadFromDisk(String Filename) {

        SSList tmp = new SSList();
        try {
            FileReader in = new FileReader(Filename);

            // Read the words in one per line
            BufferedReader buffer = new BufferedReader(in);
            String word = buffer.readLine();
            while (word != null) {
                // Read in a word - one per line - and return if an error occurs
                tmp.add(word);
                word = buffer.readLine();
            }
            buffer.close();
        } catch (IOException ex) {
            // error in opening or reading
            return false;
        }
        myList = tmp.myList;
        return true;
    }

    public boolean WriteToDisk(String Filename) {

        try {
            FileWriter out = new FileWriter(Filename);
            BufferedWriter buffer = new BufferedWriter(out);

            // Read the words in one per line
            for (int i = 0; i < myList.length; i++) {
                buffer.write(myList[i]);
                buffer.newLine();
            }
            buffer.close();
        } catch (IOException ex) {
            // an exception was found trying to create the file or writing to it
            return false;
        }
        return true;
    }

    //-------------------- Private Utility Methods------------------------------
    private void Swap(int a, int b) {
        // swaps the ath and bth values in myList
        String tmp = myList[a];
        myList[a] = myList[b];
        myList[b] = tmp;
    }

    private String CreateWord(int len) {
        // Creates a Random Capitalized Word of length len
        String tmp = "";
        Random gen = new Random();
        for (int i = 0; i < len; i++) {
            tmp += (char) ('A' + gen.nextInt(26));
        }
        return tmp;
    }

}
