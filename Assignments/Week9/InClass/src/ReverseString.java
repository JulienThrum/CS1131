public class ReverseString {
    public String reverseString(String s) {
        if(s.length() == 1) {
            return s;
        }
        //all of the following work to reverse the string
        //return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        return reverseString(s.substring(1)) + s.charAt(0);
        //return reverseString(s.substring(s.length()/2)) + reverseString(s.substring(0, s.length() / 2));
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        System.out.println(obj.reverseString("boobytrap"));
    }
}
