public class HotDog {
    public void printMenu() {
        String[] dog = {"", " Bun", " Bun, Sausage"};
        int[] calories = {0, 30, 100, 130, 20, 50, 120, 150};   //Bun, Mustard, Mayo, Catsup, Sausage
        int bun = 0; //Calories in a bun
        String addComma = "";

        //print menu
        int counter = 0;
        for (int i = 0; i < dog.length; i++) {
            if(i == 1) {
                bun = 120;
            }
            if(i == 2) {
                bun = 120 + 140;
            }

            for (int j = 0; j < calories.length; j++) {
                switch (j) {
                    case 0:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + " ", calories[j] + bun);
                        break;
                    case 1:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Catsup", calories[j] + bun);
                        break;
                    case 2:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mayo", calories[j] + bun);
                        break;
                    case 3:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mayo, Catsup", calories[j] + bun);
                        break;
                    case 4:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mustard", calories[j] + bun);
                        break;
                    case 5:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mustard, Catsup", calories[j] + bun);
                        break;
                    case 6:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mustard, Mayo", calories[j] + bun);
                        break;
                    case 7:
                        System.out.printf("%02d%-54s %d\n", counter + 1, dog[i] + addComma + " Mustard, Mayo, Catsup", calories[j] + bun);
                        break;
                }
            counter++;
            }
            addComma = ",";
        }
    }

    public static void main(String[] args) {
        HotDog obj = new HotDog();
        obj.printMenu();
    }
}