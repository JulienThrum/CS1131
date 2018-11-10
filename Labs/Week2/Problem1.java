import java.util.Scanner;
import java.lang.String;

public class Problem1
{
	public double euler(int n)
	{
	Scanner in = new Scanner(System.in);
	double e = 1;
	int factorial = 1;
	int temp = 1;

	if((n >= 1) && (n <= 100000)){
		for(int i=1; i<=n;i++){
		
		factorial *=i;
		temp = i;
		
				
		e += (1.0/factorial);
		}
	}

	return e;
	}

	public int countVowels(String s)
	{
		int length = s.length();
		
		int vowelCount = 0;
		String l = " ";	//l for letter

		for(int i = 0; i < length; i++)
		{
			l = s.substring(i, i + 1);

			if(l.compareToIgnoreCase("a") == 0 || l.compareToIgnoreCase("e") == 0 || l.compareToIgnoreCase("i") == 0 || l.compareToIgnoreCase("o") == 0 || l.compareToIgnoreCase("u") == 0 || l.compareToIgnoreCase("y") == 0)
			{
				vowelCount++;
			}
		}

		return vowelCount;
	}

	public long sumOddDigits( int n )
	{
		int r = 0;
		String y = Integer.toString(n);
		for(int i = 0; i <= y.length() - 1; i++)
		{
			if (Character.getNumericValue(y.charAt(i))%2 == 1)
			{
				r = r + Character.getNumericValue(y.charAt(i));
			}
		}
		return r;
	}

	public static void main(String[] args)
	{
		Problem1 labObject = new Problem1();
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter an integer ");
		int n = kb.nextInt();
		System.out.println(labObject.sumOddDigits(n));

		System.out.println(euler(10));
		

		Scanner in = new Scanner(System.in);

		System.out.print("Enter string: ");
		String s = in.next();

		System.out.print(countVowels(s));
	}
}