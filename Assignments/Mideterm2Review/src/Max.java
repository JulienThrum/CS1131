import java.util.Arrays;
import java.util.List;

public class Max {
    public static void main(String[] args) {
        Max obj = new Max();
        int[] test = {1, 1, 5, 1};
        System.out.println(obj.max2(test));
    }

    public List<Integer> qsort(List<Integer> list) {
        Integer temp;
        for(int i = 0; i < list.size(); i++) {

        }
    }

    public int max2(int[] list) {
        int[] left = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] right = Arrays.copyOfRange(list, list.length / 2, list.length);

        if(list.length == 1) {
            return list[0];
        }

        if(max2(left) > max2(right)) {
            return max2(left);
        }
        else if(max2(left) < max2(right)) {
            return max2(right);
        }
        else //if they're the same
            return max2(left);
    }

    public int max(int[] list) {
        int[] newlist = Arrays.copyOfRange(list, 1, list.length);
        if(list.length == 1) {
            return list[0];
        }

        if(list[0] < max(newlist)) {
            return max(newlist);
        }
        else if(list[0] > max(newlist)) {
            return max(Arrays.copyOfRange(list, 0, list.length - 1));
        }
        else{   //if they're the same
            return max(newlist);
        }
    }
}
