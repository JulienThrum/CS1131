import java.util.Arrays;
import java.util.Scanner;

/*
@author Julien Thrum
 */
public class Main {

    public static void printMethod(int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int)Math.round(Math.random());
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = in.nextInt();
        printMethod(n);
    }
}
