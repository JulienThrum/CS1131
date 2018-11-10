public class MyStringTest {
    public static void main(String[] args) {
        char[] myChar = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd'};
        char[] compareChar = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd'};
        MyString object = new MyString(myChar);
        MyString object2 = new MyString(compareChar);
        System.out.println("Length: " + object.length());
        System.out.println("Char at 4: " + object.charAt(4));
        object.toLowerCase();
        System.out.println("toLowerCase: " + object.toString());
        System.out.println(object.equals(object2));
        System.out.println(object.valueOf(65));
    }
}
