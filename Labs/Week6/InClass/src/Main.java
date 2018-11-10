import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File("test.txt");
        Scanner input = new Scanner(myFile);
        input.useDelimiter("a");
        while(input.hasNext()) {
            String line = input.next();
            System.out.println(line);
        }
        input.close();
    }
}