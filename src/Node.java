public class Node {
    private Object content = null;
    private Node previous = null;

    public Node(Object content, Node previous) {
        this.content = content;
        this.previous = previous;
    }

    public Object getContent() {
        return content;
    }
    public Node getPrevious() {
        return previous;
    }
}