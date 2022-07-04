import java.util.EmptyStackException;

/**
 * Generic version of the Stack class.
 */
class MyStack {
    /**
     * Head node contains front node in the stack
     */
    Node head;
    /**
     * default constuctor for stack
     */
    public MyStack() {
        head = null;
    }
    /**
     * check if stack is empty
     */
    boolean isEmpty() {
        return (head == null);
    }
    /**
     * clear stack
     */
    public void clear() {
        head = null;
    }
    /**
     * add new  node at head
     */
    void push(Product x) {
        head = new Node(x, head);
    }
    /**
     * pop and return item
     */
    public Product pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Product x = head.info;
        head = head.next;
        return x;
    }
    /**
     * override toString method to display stacl
     */
    @Override
    public String toString() {
        String result = "";
        Node current = head;
        while (current != null) {
            result += current.toString() + "\n";
            current = current.next;
        }
        return result;
    }
}
