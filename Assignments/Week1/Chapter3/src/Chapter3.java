import java.util.Scanner;
import java.util.Arrays;

public class Chapter3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter three numbers to be sorted from smallest to largest: "); //get input
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int[] numbers = {a, b, c};

        Arrays.sort(numbers);

        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }
}
