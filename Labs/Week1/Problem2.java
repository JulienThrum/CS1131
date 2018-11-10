import java.util.Scanner;

public class Problem2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Point (x1, y1)? ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		
		System.out.print("Point (x2, y2)? ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		System.out.println("The distance between (x1, y1) and (x2, y2) is " + dist);
	}
}
