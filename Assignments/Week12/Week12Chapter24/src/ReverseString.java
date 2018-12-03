import java.util.LinkedList;

public class ReverseString {
    private void reverseString(String s) {
        LinkedList<Character> list = new LinkedList<>();
        char[] array = s.toCharArray();

        for(int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }

        for(Character c : list) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        obj.reverseString("qwerty");
    }
}
