/**
 * Generic version of the Node class
 */
public class Node {
    /**
     * Info of this node
     */
    Product info;
    /**
     * Next node
     */
    Node next;
    /**
     * default constructor
     */
    public Node() {
    }
    /**
     *  constructor for this node with info and next node
     */
    public Node(Product info, Node next) {
        this.info = info;
        this.next = next;
    }
    /**
     * constructor for this node with info
     */
    public Node(Product info) {
        this(info, null);
    }
    /**
     * Overriding to conver this node to a string
     */
    @Override
    public String toString() {
        return this.info.toString();
    }

}
