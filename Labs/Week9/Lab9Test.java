import static org.junit.Assert.*;
import org.junit.Test;

public class Lab9Test {

    @Test
    public void sumDigits() {
        Lab9 obj = new Lab9();
        int input = 123;
        assertTrue(obj.sumDigits(123) == 6);
        assertTrue(obj.sumDigits(-123) == 6);
    }

    @Test
    public void isPalindrome() {
        Lab9 obj = new Lab9();
        assertTrue("noon", obj.isPalindrome("noon"));
        assertTrue("racecar", obj.isPalindrome("racecar"));
    }

    @Test
    public void maxValue() {
        Lab9 obj = new Lab9();
        Integer[] nums1 = {1, 2, 3, 11, 5, 112, 4, 6};
        assertTrue(obj.maxValue(nums1) == 112);
    }

    @Test
    public void fibinacci() {
        Lab9 obj = new Lab9();
        assertTrue(obj.fibonacci(4) == 3);
    }
}
