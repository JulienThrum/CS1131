import java.util.Scanner;

public class Lab3Problem1{
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		

		System.out.println("How Old are you? \t");
		int age = in.nextInt();
		if(age < 21)
			System.out.println("You are below the minimum age to drink alcohol in MI.");
		else
			System.out.println("You can buy alcohol in MI.");		
	}
}