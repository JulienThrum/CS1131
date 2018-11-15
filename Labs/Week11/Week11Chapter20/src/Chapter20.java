import java.util.Scanner;
import java.util.Stack;

public class Chapter20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.print("Enter an integer: ");
        int number = in.nextInt();

        while(number / 10 != 0) {
            stack.push(number % 10);
            number /= 10;
        }
        stack.push(number % 10);

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}