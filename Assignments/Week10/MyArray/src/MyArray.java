//Julien Thrum
//Sean Parker
//Kai Borah
//Harley Merkah

//Julien Thrum
//Sean Parker
//Harley Merkaj
//Kai Borah

public class MyArray<E> {
    @SuppressWarnings("unchecked")
    private E array[];

    public MyArray(int size) {
        array = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        if(array.length == 0) {
            return true;
        }
        else
            return false;
    }

    public boolean equals(E[] other) {
        boolean same = true;
        if(other.length != array.length) {
            return false;
        }

        for(int i = 0; i < array.length; i++) {
            if(array[i] != other[i]) {
                same = false;
            }
        }
        return same;
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString(){
        String result = "[";
        for(int i = 0; i < array.length - 2; i++) {
            result += array[i] + ", ";
        }
        result += array[array.length - 1] + "]";
        return result;
    }

    public void set(E element, int index) {
        if(index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index >=0 && index < array.length) {
            array[index] = element;
        }
        else if (index > array.length - 1) {
            array = grow(array, index);
            array[index] = element;
        }
    }

    public E get(int index) {
        if(index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(index > array.length - 1) {
            array = grow(array, index);
        }
        return array[index];
    }

    public E[] grow(E[] array, int index) {
        E[] result = (E[]) new Object[index + 1];
        for(int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        return result;
    }
}
