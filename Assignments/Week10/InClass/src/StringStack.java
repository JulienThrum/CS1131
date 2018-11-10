import java.util.ArrayList;

public class StringStack implements StackInterface{
    ArrayList<String> stack = new ArrayList<String>();
    
    @Override
    public String peek() {
        return stack.get(0);
    }

    @Override
    public String pop() {
        return stack.remove(0);
    }

    @Override
    public void push(String n) {
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
