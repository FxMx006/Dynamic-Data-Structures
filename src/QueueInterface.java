
public interface QueueInterface {
    boolean isEmpty();

    void enqueue(Object object);

    void dequeue();

    Object front();

}
