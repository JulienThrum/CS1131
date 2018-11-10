import java.util.Scanner;
import java.io.File;

public class Week6Chapter12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file directory name: ");
        String dir = in.next();

        File file = new File(dir);
        if(file.isDirectory()) {
            System.out.println("Directory already exists");
            System.exit(0);
        }
        if(file.mkdir()){
            System.out.println("Directory created successfully");
        }
    }
}
