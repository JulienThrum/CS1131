public class MyArray {
    private int [] array;

    public int get (int index) {
        return array[index];
    }

    public void set (int index, int value) {
        array[index] = value;
    }

    public MyArray(int size) {
        array = new int[size];
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);
        myArray.set(2,2);

        try {
            myArray.set(12,12);
            throw new RuntimeException("Expecting ArrayIndexOutOfBouns! myArray.set(12,12)");
        } catch(ArrayIndexOutOfBoundsException e) {
            //Test Succeeded. Do nothing.
        }

        System.out.println("All tests passed");
    }
}
