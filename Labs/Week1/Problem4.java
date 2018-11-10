import java.util.Scanner;
import java.util.Arrays;

public class Problem4
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("> ");
		
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();

		int[] array = {a, b, c};
		
		Arrays.sort(array);
		
		for(int i = 0; i <= 2; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
