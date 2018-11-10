public class ReverseString2 {
//    public String reverseString(String s) {
//        String result = "";
//        for(int i = 0; i < s.length(); i++) {
//            result = s.charAt(i) + result;
//        }
//
//        return result;
//    }

    public String reverseString(String s) {
        return reverseString(s, 0);
    }

    private String reverseString(String s, int i) {
        if(i >= s.length()) {
            return "";
        }

        return s.charAt(s.length() - i - 1) + reverseString(s, ++i);
    }

    public boolean findString (String s, String t) {
        if(s.length() < t.length()) {
            return false;
        }

        if(s.substring(0, t.length()).equals(t)) {
            return true;
        }

        return findString(s.substring(1), t);
    }

    public static void main(String[] args) {
        ReverseString2 obj = new ReverseString2();
        System.out.println(obj.reverseString("Hello!"));
        System.out.println(obj.findString("Mississippi", "sip"));
    }
}
