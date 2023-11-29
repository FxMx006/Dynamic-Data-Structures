public class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test isEmpty with an empty queue
        System.out.println("Should be true: " + queue.isEmpty());

        // Test enqueue
        queue.enqueue("Element 1");
        queue.enqueue("Element 2");
        queue.enqueue("Element 3");

        // Test isEmpty with a non-empty queue
        System.out.println("Should be false: " + queue.isEmpty());

        // Test front
        System.out.println("Should be Element 1: " + queue.front());

        // Test dequeue
        queue.dequeue();
        System.out.println("Should be Element 2: " + queue.front());

        queue.dequeue();
        System.out.println("Should be Element 3: " + queue.front());

        queue.dequeue();
        // Test isEmpty after all elements have been dequeued
        System.out.println("Should be true: " + queue.isEmpty());
    }
}
