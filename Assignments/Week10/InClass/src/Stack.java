import java.util.ArrayList;

public class Stack<E> implements StackInterface<E>{
    ArrayList<E> stack = new ArrayList<E>();

    @Override
    public E peek() {
        return stack.get(0);
    }

    @Override
    public E pop() {
        return stack.remove(0);
    }

    @Override
    public void push(E n) {
        stack.add(n);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
