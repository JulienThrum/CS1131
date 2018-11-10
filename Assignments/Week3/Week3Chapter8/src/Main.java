import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void strictlyEquals(int[][] m1, int m2[][]) {
        boolean equal = true;

        //compare values
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                if (m1[row][column] != m2[row][column]) {
                    equal = false;
                }
            }
        }

        //print equals or not
        System.out.print("Enter list1: ");
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                System.out.print(m1[row][column] + " ");
            }
        }

        System.out.print("\nEnter list2: ");
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                System.out.print(m2[row][column] + " ");
            }
        }

        if(equal)
            System.out.println("\nThe two arrays are strictly identical.");
        else
            System.out.println("\nThe two arrays are not strictly identical.");
    }

    public static void equals(int[][] m1, int[][] m2) {
        //create two new arrays and sort them, so I can see if they're strictly identical
        int index = 0;
        int[] m1Sorted = new int[9];
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                m1Sorted[index] = m1[row][column];
                index++;
            }
        }
        Arrays.sort(m1Sorted);

        index = 0;
        int[] m2Sorted = new int[9];
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                m2Sorted[index] = m2[row][column];
                index++;
            }
        }
        Arrays.sort(m2Sorted);

        boolean equal = true;

        //compare values
        for(int i = 0; i < 9; i++) {
                if (m1Sorted[i] != m2Sorted[i]) {
                    equal = false;
                }
            }


        //print equals or not
        System.out.print("Enter list1: ");
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                System.out.print(m1[row][column] + " ");
            }
        }


        System.out.print("\nEnter list2: ");
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                System.out.print(m2[row][column] + " ");
            }
        }

        if(equal)
            System.out.println("\nThe two arrays are identical.");
        else
            System.out.println("\nThe two arrays are not identical.");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] m1= new int[3][3];
        int[][] m2= new int[3][3];

        System.out.println("Enter a 3x3 array:");

        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                m1[row][column] = in.nextInt();
            }
        }

        System.out.println("Enter another 3x3 array");

        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                m2[row][column] = in.nextInt();
            }
        }

        strictlyEquals(m1, m2);
        System.out.println();
        equals(m1, m2);
    }
}
