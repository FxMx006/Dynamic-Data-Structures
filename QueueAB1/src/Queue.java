public class Queue implements QueueInterface {
    ListElement anchor;
    ListElement tail;

    public Queue() {
        this.anchor = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return anchor == null;
    }

    @Override
    public void enqueue(Object pObject) {
        if (pObject != null) {
            ListElement newElement = new ListElement(null, pObject, null);
            if (isEmpty()) {
                anchor = newElement;
                tail = newElement;
            } else {
                tail.setNext(newElement);
                tail = newElement;
            }
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty()) {
            anchor = anchor.getNext();
            if (anchor == null) {
                tail = null;
            }
        }
    }

    @Override
    public Object front() {
        if (!isEmpty()) {
            return anchor.getContent();
        } else {
            return null;
        }
    }
}
