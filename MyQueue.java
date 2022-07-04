/**
 * Generic version of the Queue class.
 */
class MyQueue {
    /**
     * Head node contains front node in the queue
     */
    Node head;
    /**
     * Tail node contains last node in the queue
     */
    Node tail;

    /**
     * default constuctor for queue
     */
    public MyQueue() {
        head = tail = null;
    }
    /**
     * checking if this queue is empty
     */
    boolean isEmpty() {
        return (head == null);
    }
    /**
     * clear queue
     */
    public void clear() {
        head = tail = null;
    }
    /**
     * dequeue and return info
     */
    public Product dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        Product x = head.info;
        head = head.next;
        if(head == null) tail = null;
        return x;
    }
    /**
     * enqueue
     */
    void enqueue(Product item) {
        Node newNode = new Node(item);
        if(isEmpty()) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }
    /**
     * override toString method to display queue
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
