import java.util.ArrayList;

public class MyArrayQueue<E> {
    private E[] queue = (E[]) new Object[10];
    int front = 5;
    int back = 5;
    int size = 0;

    private boolean isFull() {
        return front == back && size > 0;
    }

    public void enqueue(E value) {
        if(isFull()) {
            throw new RuntimeException("Queue is full");
        }
        queue[back++] = value;
        back = back % queue.length;
        size++;
    }

    public E peek() {
        if(isEmpty()) {
            throw new RuntimeException("Empty Queue");
        }

        return queue[front];
    }

    public E dequeue() {
        E result = peek();  //peek checks for is empty, no nee
        // d for it in dequeue
        front = (front + 1) % queue.length;
        size--;
        return result;
    }

    public boolean isEmpty() {
        return size == 0 && front == back;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyArrayQueue<Character> queue = new MyArrayQueue<>();
        for(Character c : "Hello".toCharArray()) {
            queue.enqueue(c);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}