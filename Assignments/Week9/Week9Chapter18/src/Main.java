public class Main {

    private static int fibCount = 0;

    public String reverseString(String s) {
        if(s.length() == 1) {
            return s;
        }

        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    public int xToTheY(int x, int y) {
        if(y == 1) {
            return x;
        }

        return x * xToTheY(x, y - 1);
    }

    public int fibonacci(int n) {
        fibCount++;

        if (n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.xToTheY(7, 7));
        System.out.println(obj.reverseString("boobytrap"));
        System.out.println("fib(5) = " + obj.fibonacci(5) + "\tfibCount = " + fibCount);
        fibCount = 0;
        System.out.println("fib(6) = " + obj.fibonacci(6) + "\tfibCount = " + fibCount);
        fibCount = 0;
        System.out.println("fib(7) = " + obj.fibonacci(7) + "\tfibCount = " + fibCount);
        fibCount = 0;
        System.out.println("fib(8) = " + obj.fibonacci(8) + "\tfibCount = " + fibCount);

    }
}
