import java.lang.reflect.Array;

public class Main {
    public static <E> boolean palindrome(E[] element) {
        boolean same = true;
        for(int i = 0; i < element.length; i++) {
            if(element[i] != element[element.length - 1 - i]) {
                same = false;
                break;
            }
        }
        return same;
    }
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3, 2, 1};
        System.out.println(palindrome(array));
        Integer[] array2 = {1, 2, 3, 3, 2, 1, 1};
        System.out.println(palindrome(array2));
    }
}
