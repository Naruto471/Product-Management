/**
 * Generic version of the linkedlist class
 */
public class MyList {
    /**
     * head and tail node is null
     */
    Node head;
    Node tail;
    /**
     * Default constructor
     */
    public MyList() {
        head = tail = null;
    }
    /**
     * Constructor with head and tail
     */
    public MyList(Node head, Node tail) {
        head = head;
        tail = tail;
    }
    /**
     * checking if this list is empty
     */
    boolean isEmpty() {
        return (head == null);
    }
    /**
     * returning the length of this list
     */
    public int length() {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    /**
     * Insert an item to the head of this list
     */
    public void insertToHead(Product item) {
        Node newNode = new Node(item, head.next);
        if (head == null) {
            head = tail = newNode;
        }
        head = newNode;
    }
    /**
     * insert an item at the tail of this list
     */
    public void insertAtTail(Product item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
    }
    /**
     * deleting the tail of this list
     */
    public void deleteTail() {
        tail = null;
    }
    /**
     * Searching and deleting an item from this list by comparing the ID of items
     */
    public void deleteElement(Product item) {
        Node current = head;
        Node preNode = null;
        if (head.info.bcode.equals(item.bcode)) {
            if (head == tail) {
                head = tail = null;
            }
            else {
                head = head.next;
            }
        }
        while (current.next != null) {
            if (current.next.info.bcode.equals(item.bcode)) {
                current.next = current.next.next;
                return;
            }
            preNode = current;
            current = current.next;
        }
        // check if last product of list equal product x or not
        if (current.info.bcode.equals(item.bcode)) {
            preNode.next = current.next;
            tail = preNode;
        } else {
            System.out.println("Not found");
        }

    }
    /**
     * Swaping two node first and second node
     */
    public void swap(Node firstNode, Node secondNode) {
        // check if list empty or info of node1 and node2 equal or not
        if (firstNode.info.equals(secondNode.info) || head == null) {
            return;
        }
        Node prevNode1 = null;
        Node prevNode2 = null;
        Node node1 = head, node2 = head;
        // search for node1
        while (node1 != null && !firstNode.info.equals(node1.info)) {
            prevNode1 = node1;
            node1 = node1.next;
        }
        //search for node2
        while (node2 != null && !secondNode.info.equals(node2.info)) {
            prevNode2 = node2;
            node2 = node2.next;
        }
        // if either node1 or node2 is not present, return
        if (node1 == null || node2 == null) {
            return;
        }
        // if node1 is the head of the list
        if (prevNode1 == null) {
            head = node2;
            // if node2 is the tail of the list
            if (node2 == tail) {
                tail = node1;
            }
        } // node1 is not the head
        else {
            prevNode1.next = node2;
            // node2 is the tail of the list
            if (node2 == tail) {
                tail = node1;
            }
        }
        // if node2 is the head  of the list
        if (prevNode2 == null) {
            head = node1;
            // if node1 is the tail of the list
            if (node1 == tail) {
                tail = node2;
            }
        }
        else {
            prevNode2.next = node1;
            // nod1 1 is the tail of the list
            if (node1 == tail) {
                tail = node2;
            }
        }
        // swap next pointer
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;

    }
    /**
     * deleting all item in the list
     */
    public void clear() {
        head = tail = null;
    }
    /**
     * convert list to string to diplay
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
