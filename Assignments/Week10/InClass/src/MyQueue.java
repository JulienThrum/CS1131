import java.util.ArrayList;

public class MyQueue<E> {
    private ArrayList<E> queue = new ArrayList<E>();

    public void enqueue(E value) {
        queue.add(0, value);
    }

    public E peek() {
        return queue.get(queue.size() - 1);
    }

    public E dequeue() {
        return queue.remove(queue.size() - 1);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        MyQueue<Character> queue = new MyQueue<>();
        for(Character c : "Hello".toCharArray()) {
            queue.enqueue(c);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
