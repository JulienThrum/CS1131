public class Test {
    public static void main(String[] args) {
        int i = 11;

        while(i < 100) {

            double tensPlace = Math.floor(i / 10);

            int onesPlace = i % 10;

            System.out.println(i);

            if(tensPlace == onesPlace) {

                i = (int)(Math.floor((i + 10) / 10) * 10 + 1);
            } else {

                i++;

            }
        }
    }
}
