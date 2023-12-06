public class Queue implements QueueInterface {
    private Node head = null;
    private Node tail = null;

    public Queue(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void enqueue(Object object) {
        if (object == null) {
            return;
        }
        Node newNode = new Node(object, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        }
    }

    @Override
    public Object front() {
        if (!isEmpty()) {
            return head.getContent();
        }
        return null;
    }
    public void prioEnqueue(Patient patient) {
        if (patient == null) {
            return;
        }
        Node newNode = new Node(patient, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            if (patient.getAge() > ((Patient) head.getContent()).getAge()) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node current = head;
                while (current.getNext() != null && ((Patient) current.getNext().getContent()).getAge() > patient.getAge()) {
                    current = current.getNext();
                }
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (newNode.getNext() == null) {
                    tail = newNode;
                }
            }
        }
    }
}
