public class CountUppercase {

    public int countCaps(String s) {
        if(s.length() <= 1) {
            if(s.isEmpty()) {
                return 0;
            }

            if(Character.isUpperCase(s.charAt(0))) {
                return 1;
            }

            return 0;
        }

        return countCaps((s.substring(s.length() / 2)) + countCaps(s.substring(0, s.length() / 2)));
    }

    public static void main(String[] args) {
        CountUppercase obj = new CountUppercase();
        System.out.println(obj.countCaps("StoirASOdinfjsiaoAS"));
    }
}
