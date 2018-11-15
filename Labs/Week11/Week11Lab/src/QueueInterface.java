
/**
 * Defines the interface to a queue collection.
 */
public interface QueueInterface<T>
{
    /**  
     * Adds one element to the rear of this queue. 
     * @param element  the element to be added to the rear of the queue  
     */
    public void enqueue(T element);

    /**  
     * Removes and returns the element at the front of this queue.
     * @throws QueueEmptyException when there are no elements in the queue.
     * @return the element at the front of the queue
     */
    public T dequeue() throws QueueEmptyException;

    /**  
     * Returns without removing the element at the front of this queue.
     * @throws QueueEmptyException when there are no elements in the queue.
     * @return the first element in the queue
     */
    public T peek() throws QueueEmptyException;
   
    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size();

    /**  
     * Returns a string representation of this queue. 
     * Should be of the form: "<Queue:[1, 2, 3, 4, 5]>"
     * @return the string representation of the queue
     */
    public String toString();
}
