public interface StackInterface<V> {

    public V peek();
    public V pop();
    public void push(V n);
    public int size();
    public boolean isEmpty();
    }
}
