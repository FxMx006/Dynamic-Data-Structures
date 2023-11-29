public class Stack implements StackInterface {
    private ListElement head;
    private ListElement tail;

    public Stack() {
        head = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(Object pObject) {
        if (pObject == null) {
            return;
        }
        ListElement newElement = new ListElement(pObject);
        if (isEmpty()) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
        }
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    @Override
    public Object top() {
        if (!isEmpty()) {
            return tail.data;
        }
        return null;
    }
}
