import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> stack = new ArrayList<E>();

    public void push(E value) {
        stack.add(value);
    }

    public E peek() {
        return stack.get(stack.size() - 1);
    }

    public E pop() {
        E result = peek();
        stack.remove(stack.size() - 1);
        return result;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        for(Character c : "Hello".toCharArray()) {
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
