import java.util.ArrayList;

public class Queue<E> implements QueueInterface<E> {

    private ArrayList<E> queue;

    private int max = -1;

    public Queue(int max) {
        queue = new ArrayList<>();
        this.max = max;
    }

    @Override
    public void enqueue(E element) throws QueueFullException {
        queue.add(0, element);
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.remove(queue.size() - 1);
    }

    @Override
    public E peek() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.get(queue.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return size() == max;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        String result = "";

        for(int i = queue.size() - 1; i > -1; i--) {
            result += queue.get(i);
        }

        return result;
    }
}

