import java.util.Arrays;

public class IceCream {
    // returns the number of combinations
    public long printMenu() {
        String[] flavors = {"", " Vanilla", " Strawberry", " Chocolate"};
        double[] price = {0.0, 0.4, 0.35, 0.75, 0.15, 0.55, 0.5, 0.9, 1.15, 1.55, 1.5, 1.9, 1.3, 1.7, 1.65, 2.05, 1.35, 1.75, 1.7, 2.1, 1.5, 1.9, 1.85, 2.25, 1.75, 2.15, 2.1, 2.5, 1.9, 2.3, 2.25, 2.65};
        String addComma = "";

        //print menu
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + " ", price[counter]);
                        break;
                    case 1:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Chocolate Chips", price[counter]);
                        break;
                    case 2:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Whipped Cream", price[counter]);
                        break;
                    case 3:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Whipped Cream, Chocolate", price[counter]);
                        break;
                    case 4:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Sprinkles", price[counter]);
                        break;
                    case 5:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Sprinkles, Chocolate Chips", price[counter]);
                        break;
                    case 6:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Sprinkles, Whipped Cream", price[counter]);
                        break;
                    case 7:
                        System.out.printf("%02d%-54s $%02.2f\n", counter, flavors[i] + addComma + " Sprinkles, Whipped Cream, Chocolate Chips", price[counter]);
                        break;
                }
                counter++;
            }
            addComma = ",";
        }

        return counter;
    }

    public static void main(String[] args) {
        IceCream obj = new IceCream();
        long count = obj.printMenu();
        assert count == 32;
    }
}