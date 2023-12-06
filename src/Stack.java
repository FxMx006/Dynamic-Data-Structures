public class Stack implements StackInterface {
    private Node top = null;

    public Stack() {}

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(Object pObject) {
        if (pObject != null) {
            top = new Node(pObject, top);
        }
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            top = top.getPrevious();
        }
    }

    @Override
    public Object top() {
        if (!isEmpty()) {
            return top.getContent();
        }
        return null;
    }
}