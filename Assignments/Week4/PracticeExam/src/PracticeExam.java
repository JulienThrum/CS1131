import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PracticeExam {
    public ArrayList<Integer> filterOdds(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 != 0) {
                list.remove(i);
            }
        }
        return list;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A[0].length][B.length];

        System.out.println("rows: " + result.length + " Columns: " + result[0].length);
        for(int row = 0; row < A[0].length; row++) {
            for(int column = 0; column < B.length; column++) {
                for(int index = 0; index < A.length; index++) {
                    result[row][column] += A[row][index] * B[index][column];
                }

            }
        }
        return result;
    }

    public String join(String[] list, String delim) {
        String result = "";
        for(int i = 0; i < list.length; i++) {
            if(i != list.length - 1) {
                result += list[i] + delim;
            } else
                result += list[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PracticeExam obj = new PracticeExam();
        String[] list = {"a", "b", "c"};
        System.out.println(obj.join(list, "-"));
//        int[][] A = {
//                {1, 2},
//                {2, 1}
//        };
//        int[][] B = {
//                {3, 4},
//                {4, 5}
//        };
//
//        int[][] result = obj.multiply(A, B);
//        System.out.println(Arrays.deepToString(result));

//        ArrayList<Integer> otherList = new ArrayList<Integer>();
////
////        int temp = 0;
////
////        ArrayList<Integer> list = new ArrayList<Integer>();
////        list.add(1);
////        list.add(2);
////        list.add(4);
////        list.add(1);
////        list.add(8);
////        list.add(9);
////        list.add(16);
////        ArrayList<Integer> newList = new ArrayList<>();
////        newList = obj.filterOdds(list);
////        System.out.println(newList);
////
////        System.out.print("Enter amount of items to be in list: ");
////        int amount = in.nextInt();
////
////        System.out.print("Enter items: ");
////        for(int i = 0; i < amount; i++) {
////            temp = in.nextInt();
////            otherList.add(temp);
////        }
////
////        newList = obj.filterOdds(otherList);
////        System.out.println(otherList);
    }
}
