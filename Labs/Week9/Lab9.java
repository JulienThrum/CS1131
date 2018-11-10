import java.util.Arrays;

public class Lab9 {

    public int fibonacci(int n) {
        if (Math.abs(n) <= 1) {
            return Math.abs(n);
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public int sumDigits(int n) {
        if(Integer.toString(n).substring(0,1).equals("-")){
            return sumDigits(Integer.parseInt(Integer.toString(n).substring(1, Integer.toString(n).length()))) * -1;
        }

        if(Integer.toString(n).length() == 1) {
            return n;
        }

        return Integer.parseInt(String.valueOf(Integer.toString(n).substring(Integer.toString(n).length() - 1)))
                + sumDigits(Integer.parseInt(Integer.toString(n).substring(0, Integer.toString(n).length() - 1)));
    }

    public boolean isPalindrome( String s ) {
        boolean result = false;
        if ( s.length() <= 1 ) {
            return true;
        }
        if (Character.toLowerCase(s.toCharArray()[0]) == Character.toLowerCase(s.toCharArray()[s.length()-1])) {
            result = isPalindrome(new String(Arrays.copyOfRange(s.toCharArray(), 1, s.length()-1)));
        } else {
            return false;
        }
        return result;
    }

    public Integer maxValue( Integer[] a ) {
        if (a.length <= 1) {
            return a[0];
        }
        return (a[0] > a[a.length-1]) ? maxValue(Arrays.copyOfRange(a, 0, a.length-1)) : maxValue(Arrays.copyOfRange(a, 1, a.length));

    }

    public static void main(String[] args) {
	    Lab9 obj = new Lab9();

	    Integer[] nums = {1, 2, 3, 11, 5, 112, 4, 6};
        System.out.println(obj.isPalindrome("racecar"));
        System.out.println(obj.sumDigits(1234));
        System.out.println(obj.maxValue(nums));
        System.out.println(obj.fibonacci(4));

    }
}
