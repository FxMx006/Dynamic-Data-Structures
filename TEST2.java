public class TEST2 {
    //---------------------Stack-------------------------------------------------
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
    //-----------------------------Queue-------------------------------#
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
}
