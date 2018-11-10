/*
    @author Julien Thrum
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a character: ");
        String input = in.next();

        System.out.println("The Unicode character " + input.charAt(0) + " has the value " + (int)input.charAt(0));
    }
}
