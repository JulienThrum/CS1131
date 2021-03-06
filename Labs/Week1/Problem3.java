import java.util.Scanner;

public class Problem3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();

		double d1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		double d2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
		double d3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

		double s = (d1 + d2 + d3) / 2;
		
		double area = Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
		
		System.out.println("Area: " + area);
	}
}
