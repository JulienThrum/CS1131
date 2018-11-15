import java.util.ArrayList;

public class Queue<E> implements QueueInterface<E>{
    private ArrayList<E> queue = new ArrayList<>();

    public void enqueue(E value) {
        queue.add(0, value);
    }

    public E peek() throws QueueEmptyException{
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return queue.get(queue.size() - 1);
    }

    public E dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }
        return queue.remove(queue.size() - 1);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public String toString() {
        String result = "<Queue:[";

        for(int i = queue.size() - 1; i > -1; i--) {
            if(i > 0) {
                result += queue.get(i) + ", ";
            }else
                result += queue.get(i);
        }

        return result += "]>";
    }

    public static void main(String[] args) {
        Queue<Character> queue = new Queue<>();
        for(Character c : "Hello".toCharArray()) {
            queue.enqueue(c);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }


    }
}
