import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayTest {

    MyArray<Integer> array = new MyArray<>(3);

    @Test
    public void isEmpty() {
        //set();
        System.out.println(array.isEmpty());
    }

    @Test
    public void equals() {
        set();
        MyArray<Integer> array2 = new MyArray<>(3);
        array2.set(0, 0);
        array2.set(1, 1);
        array2.set(2, 2);
        System.out.println(array.equals(array2));
    }

    @Test
    public void size() {
        set();
        System.out.println(array.size());
    }

    @Test
    public void set() {
        array.set(0, 0);
        array.set(1, 1);
        array.set(2, 2);
    }

    @Test
    public void get() {
        set();
        System.out.println(array.get(0));
        System.out.println(array.get(3));
        System.out.println(array.get(2));
    }
}