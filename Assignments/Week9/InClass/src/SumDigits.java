public class SumDigits {
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

    public static void main(String[] args) {
        SumDigits obj = new SumDigits();
        System.out.println(obj.sumDigits(Integer.MAX_VALUE));
    }
}
