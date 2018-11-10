import java.util.Scanner;

public class Problem1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Investment Amount? ");
		double invest = input.nextDouble();

		System.out.print("Annual Interest Rate? ");
		double interest = input.nextDouble();

		System.out.print("Number of Years? ");
		double years = input.nextDouble();

		double future = invest * (Math.pow((1 + (interest / 100 / 12)), (years * 12)));
		System.out.println("Future Investment Amount = " + future);
	}
}
