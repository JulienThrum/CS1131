/*
*
*@author Julien Thrum
*
*
*/

import java.util.Scanner;

public class Chapter2
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the number of minutes: ");
    double min = in.nextDouble();

    double years = Math.floor(min / 525600); // 525600 is minutes in a year
    double days = Math.floor(min % 525600) / 60 / 24;

    System.out.println(min + " minutes is approximately " + (int)years + " years and " + (int)days + " days");
  }
}
