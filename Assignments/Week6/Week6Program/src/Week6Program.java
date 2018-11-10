import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;

public class Week6Program {

    public void constructBaby(char gender, int rank, String name, int count, BabyName[] baby, int counter) {
        baby[counter] = new BabyName(gender, rank, name, count);
    }

    public static void main(String[] args) {
        Week6Program obj = new Week6Program();
        int counter = 0;
        File fin = null;
        Scanner in = null;
        int rank = 0;
        BabyName[] baby = new BabyName[2000];

        try {
            fin = new File("babynamesranking2002.txt");
            in = new Scanner(fin);
            while(in.hasNext()) {
                //use the constructor and set non-possible values
                obj.constructBaby('A', -1, "", -1, baby, counter);
                obj.constructBaby('A', -1, "", -1, baby, counter + 1);
                //set the rank
                rank = in.nextInt();
                baby[counter].setRank(rank);
                baby[counter + 1].setRank(rank);

                //set gender
                baby[counter].setGender('M');
                baby[counter + 1].setGender('F');

                //get name and counter for guys
                baby[counter].setName(in.next());
                baby[counter].setCount(in.nextInt());


                //get name and counter for girls
                baby[counter + 1].setName(in.next());
                baby[counter + 1].setCount(in.nextInt());

                counter += 2;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                in.close();
            }
        }

        //print top 5 female names
        System.out.println("Top 5 female names:");
        for(int i = 1; i < 5 * 2; i = i + 2) {
            System.out.print(baby[i].toString());
        }

        //print top 5 male names
        System.out.println("\nTop 5 male names:");
        for(int i = 0; i < 5 * 2; i = i + 2) {
            System.out.print(baby[i].toString());
        }

        //print top 10 names
        System.out.println("\nTop 10 most popular names:");
        int[] topCounts = new int[20];
        for(int i = 0; i < 20; i++) {
            topCounts[i] = baby[i].getCount();
        }
        Arrays.sort(topCounts);
        for(int i = 19, k = 0; i > 9 && k < 10; i--, k++) {
            for(int j = 0; j < 20; j++) {
                if(baby[j].getCount() == topCounts[i]) {
                    System.out.print(baby[j].toString());
                }
            }
        }

        //print bottom 10 names
        System.out.println("\nTop 10 least popular names:");
        ArrayList<BabyName> bottomCounts = new ArrayList<BabyName>();
        for(int i = 0; i < 2000; i++) {
            bottomCounts.add(baby[i]);
        }
        Collections.sort(bottomCounts, (b1, b2) -> b1.getCount() - b2.getCount());
        for(int i = 9; i >= 0; i--) {
            System.out.print(bottomCounts.get(i).toString());
        }

        //print 6 median popularity names
        System.out.println("\n6 median names:");
        for(int i = 1002; i > 996; i--) {
            System.out.print(bottomCounts.get(i).toString());
        }
    }

    private class BabyName {
        private int rank;
        private char gender;
        private String name;
        private int count;

        public BabyName(char gender, int rank, String name,
                        int count) {
            this.gender = gender;
            this.rank = rank;
            this.name = name;
            this.count = count;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("%4d %c %-15s %d\n", rank, gender, name, count);
        }
    }
}