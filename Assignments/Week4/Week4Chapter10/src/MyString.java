public class MyString {
    private char[] chars;

    public char charAt(int index) {
        return chars[index];
    }

    public int length() {
        return chars.length;
    }

    public MyString toLowerCase() {
        char[] result = new char[chars.length];
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z')
                result[i] += chars[i] - 32;
            else
                result[i] += chars[i];
        }
        return new MyString(result);
    }

    public MyString subString(int begin, int end) {
        char[] result = new char[end - begin];
        for(int i = begin; i < end; i++) {
            result[i] = this.chars[i];
        }
        return new MyString(result);
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    public static MyString valueOf(int i) {
        char[] result = {(char) i};
        return new MyString(result);
    }

    public boolean equals(MyString s) {
        boolean same = true;
        if(s.length() == chars.length) {
            for(int i = 0; i < chars.length; i++) {
                if(s.charAt(i) != chars[i])
                    same = false;
            }
        } else
            same = false;
        return same;
    }

    public MyString(char[] chars) {
        this.chars = chars;
    }
}
