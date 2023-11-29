public interface QueueInterface {
    boolean isEmpty();
    void enqueue(Object pObject);
    void dequeue();
    Object front();
}
