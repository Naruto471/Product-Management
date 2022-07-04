import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {
    /**
     * Searching and returning  the index of product p in the list, if not found return -1
     */
    public int index(Product p, MyList list) {
        if (list.isEmpty()) {
            return  -1;
        }
        int index = 0;
        Node current = list.head;
        while (current != null) {
            if (current.info.equals(p)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    /**
     * Creating and returning a product with info input from keyboard.
     */
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        String bcode = sc.next();
        System.out.println("Title: ");
        String title = sc.next();
        System.out.println("Quantity: ");
        Integer quantity = sc.nextInt();
        System.out.println("Price: ");
        double price = sc.nextDouble();
        return new Product(bcode, title, quantity, price);
    }
    /**
     * Reading all product from file and add them to the list at tail
     */
    public void getAllItemsFromFile(String fileName, MyList list) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] infos = line.split(",");
                // create a product and insert at tail
                Product newProduct = new Product(infos[0], infos[1], Integer.parseInt(infos[2]), Double.parseDouble(infos[3]));
                list.insertAtTail(newProduct);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Reading all product from file and insert them to stack
     */
    public void getAllItemsFromFile(String fileName, MyStack myStack) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] infos = line.split(",");
                //create product and insert to stack
                Product newProduct = new Product(infos[0], infos[1], Integer.parseInt(infos[2]), Double.parseDouble(infos[3]));
                myStack.push(newProduct);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Reading all product from file and insert to queue
     */
    public void getAllItemsFromFile(String fileName, MyQueue myQueue) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] infos = line.split(",");
                Product newProduct = new Product(infos[0], infos[1], Integer.parseInt(infos[2]), Double.parseDouble(infos[3]));
                myQueue.enqueue(newProduct);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Adding a product to the list, info of the product input from keyboard
     */
    public void addLast(MyList list) {
        Product item = createProduct();
        list.insertAtTail(item);
    }
    /**
     * Printing all product of the list to console screen
     */
    public void displayAll(MyList list) {
        System.out.println(list.toString());
    }
    /**
     * Printing all product of the queue to console screen
     */
    public void displayAll(MyQueue myQueue) {
        System.out.println(myQueue.toString());
    }
    /**
     * Printing all product of the stack to console screen
     */
    public void displayAll(MyStack myStack) {
        System.out.println(myStack.toString());
    }
    /**
     * Writting all products from list to file
     */
    public void writeAllItemsToFile(String fileName, MyList list) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Node current = list.head;
            while (current != null) {
                writer.write(current.info.toString() + "\n");
                current = current.next;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Searching product by ID input from keyboard
     */
    public void searchByCode(MyList list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input ID to search: ");
        String ID = sc.next();
        Node current = list.head;
        while (current != null) {
            if (current.info.bcode.equals(ID)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        System.out.println(-1 + " (Not found)");
    }
    /**
     * Deleting first product that has the ID input from the keyboard
     */
    public void deleteByCode(MyList list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input ID to delete: ");
        String ID = sc.next();
        // store head node
        Node current = list.head;
        Node preNode = null;
        // if head node itself holds the key to be deleted
        if (current != null && current.info.bcode.equals(ID)) {
            if (list.head == list.tail) {
                list.head = list.tail = null;
                return;
            } else {
                list.head = list.head.next;
                return;
            }
        }
        // search for  key to be delete, keep track of previous node
        while (current != null && !current.info.bcode.equals(ID)) {
            preNode = current;
            current = current.next;
        }
        // if key was not present in list
        if (current == null) {
            System.out.println("Not found");
            return;
        }
        // unlink the node from list
        // check if the node present at the tail of the list or not
        if (current.next == null) {
            preNode.next = current.next;
            list.tail = preNode;
        } else {
            preNode.next = current.next;
        }
    }
    /**
     * Sorting product in list by ID
     */
    public void sortByCode(MyList list) {
        // Node current will point to head
        Node current = list.head;
        Node index = null;
        Product temp;
        if (current == null) {
            return;
        }
        else {
            while (current != null) {
                // node index will point to node next to current
                index = current.next;
                while (index != null) {
                    if (current.info.bcode.compareTo(index.info.bcode) > 0) {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    /**
     * sorting using quicksort
     */
    public void sort(Node start, Node end) {
        if (start == null || start == end || start == end.next) {
            return;
        }
        // split list and partrition recurse
        Node prePivot = patritionLast(start, end);
        sort(start, prePivot);
        // if pivot is picked and move to the start
        // that mean pivot and start is same
        // so pick from next of pivot
        if (prePivot != null && prePivot == start) {
            sort(prePivot.next, end);
        }
        // if pivot is between the list
        else if (prePivot != null && prePivot.next != null) {
            sort(prePivot.next.next, end);
        }
    }
    /**
     * patrition devide linked list by pivot node
     * @param start
     * @param end
     * @return node before pivot node (end)
     */
    Node patritionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node prePivot = start;
        Node curr = start;
        Product pivot = end.info;
        // iterate till one before the end
        while (start != null) {
            if (start.info.bcode.compareTo(pivot.bcode) < 0) {
                // keep track of last modified item
                prePivot = curr;
                Product temp = curr.info;
                curr.info = start.info;
                start.info = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        // swap the position of current and pivot
        Product temp = curr.info;
        curr.info = pivot;
        end.info = temp;

        // return node before pivot node
        return prePivot;
    }
    /**
     * Adding new product to head of the linked list, input from keyboard
     */
    public void addFirst(MyList list) {
        Product newProduct = createProduct();
        list.insertToHead(newProduct);
    }
    /**
     * Convert a decimal to a integer
     */
    public int convertToBinary(int i) {
        String convert = Integer.toBinaryString(i);
        return Integer.parseInt(convert);
    }
    /**
     * Deleting the product at position
     */
    public void deleteAtPosition(MyList list, int pos) {
        if (list.isEmpty()) {
            return;
        }
        // Node current point to head
        Node current = list.head;
        // Node preNode point to node before current node
        Node preNode = null;
        int count = 0;
        while (current != null) {
            if (pos == count) {
                if (pos == 0) {
                    if (list.head == list.tail) {
                        list.head = list.tail = null;
                        return;
                    }
                    else {
                        list.head = list.head.next;
                    }
                } else {
                    preNode.next = current.next;
                }
            }
            preNode = current;
            current = current.next;
            count++;
        }
        // if delete last product in list
        if (count == pos) {
            list.tail = preNode;
            preNode.next = current.next;
        } else {
            System.out.println("Not found");
        }


    }
}
