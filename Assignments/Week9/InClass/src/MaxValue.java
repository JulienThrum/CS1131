import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxValue {

    public Integer maxValue( Integer[ ] a ) {
        if(a.length == 1) {
            return a[0];
        }

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(a));

        if(a[a.length - 1] > a[a.length - 2]) {
            list.remove(a.length - 2);
        }
        else if(a[a.length - 1] < a[a.length - 2]) {
            list.remove(a.length - 1);
        }

        Integer newArr[] = new Integer[list.size()];

        for(int i = 0; i < newArr.length; i++) {
            newArr[i] = list.get(i);
        }

        return maxValue(newArr);
    }

    public static void main(String[] args) {
        Integer a[] = {2, 16, 8, 4};
        MaxValue obj = new MaxValue();
        System.out.println(obj.maxValue(a));
    }
}
