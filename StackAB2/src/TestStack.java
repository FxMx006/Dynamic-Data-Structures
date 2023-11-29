public class TestStack {
    public static void main(String[] args) {
        StackInterface stack = new Stack();

        // Test isEmpty on an empty stack
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Test push
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");

        // Test isEmpty on a non-empty stack
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Test top
        System.out.println("Top of the stack: " + stack.top());

        // Test pop
        stack.pop();
        System.out.println("Top of the stack after pop: " + stack.top());

        // Test pop until the stack is empty
        stack.pop();
        stack.pop();
        System.out.println("Is the stack empty after popping all elements? " + stack.isEmpty());
    }
}
