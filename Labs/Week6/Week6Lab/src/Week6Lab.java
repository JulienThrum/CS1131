import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 * DESCRIBE THE ASSIGNMENT HERE
 *
 * @author YOUR NAME
 */
public class Week6Lab {
    /**
     * Loads the input file specified by the filename parameter.
     * The first line of the data file contains the number of contacts in the file.
     * Thereafter, each line of the data file contains a name followed by a space
     * followed by an email address.
     * <p>
     * Store the data in a two-dimensional array.
     * Then return the array from the method.
     */
    public String[][] loadContacts(String filename) {
        String[][] contacts = null;
        Scanner input = null;
        File inFile = null;
        int index = 0;
        int counter = 0;
        try {
            inFile = new File(filename);
            input = new Scanner(inFile);
            index = input.nextInt();
            contacts = new String[2][index];
            while(input.hasNext() && counter < index) {
                contacts[0][counter] = input.next();
                contacts[1][counter] = input.next();
                counter++;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                input.close();
            }
        }
        return contacts;
    }

    /**
     * prints to the console, the contacts that have been loaded.
     * Each contact should be printed as follows:
     * <p>
     * NAME:  Doc
     * EMAIL: DOC@foo.com
     * <p>
     * NOTE: Use printf and a tab to maintain the alignment.
     */
    public void printContacts(String[][] array) {
        for(int i = 0; i < array[0].length; i++) {
            System.out.printf("%-7s%s\n", "Name: ", array[0][i]);
            System.out.printf("%-7s%s\n\n","Email: ", array[1][i]);
        }
    }

    /**
     * Writes the contacts that have been loaded to the output file specified by the filename parameter.
     * The output file should begin with the number of records on a line by itself. Every line thereafter
     * contains a record formatted with an email address and a name separated by a tab.
     * <p>
     * 7
     * DOC@foo.com Doc
     * DOPEY@foo.com Dopey
     * BASHFUL@foo.com Bashful
     * GRUMPY@foo.com Grumpy
     * SNEEZY@foo.com Sneezy
     * SLEEPY@foo.com Sleepy
     * HAPPY@foo.com Happy
     * <p>
     * NOTE: Use printf and a tab to maintain the alignment.
     */
    public void writeContacts(String filename, String[][] array) {
        File fout = new File(filename);
        PrintWriter pwt = null;
        try {
            pwt = new PrintWriter(fout);
            pwt.println(array[0].length);
            for(int i = 0; i < array[0].length; i++) {
                pwt.printf("%s\t%s\n", array[1][i], array[0][i]);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(pwt != null) {
                pwt.close();
            }
        }
    }

    /**
     * You can use the main method for testing.
     *
     * @param args
     */
    public static void main(String[] args) {
        Week6Lab obj = new Week6Lab();

        String[][] array = obj.loadContacts("input.txt");
        obj.printContacts(array);
        obj.writeContacts("output.txt", array);
    }

}
