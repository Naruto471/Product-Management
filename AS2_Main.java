import java.util.Scanner;

public class AS2_Main {
    public static void main(String[] args) {
        System.setOut(new DoublePrintSteam(System.out, "console_output.txt"));
        Scanner sc = new Scanner(System.in);
        MyList list = new MyList();
        MyQueue myQueue = new MyQueue();
        MyStack myStack = new MyStack();
        OperationToProduct operation = new OperationToProduct();
        String input = "input.txt";
        boolean stop = true;
        do {
            showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.clear();
                    operation.getAllItemsFromFile(input, list);
                    operation.displayAll(list);
                    break;
                case 2:
                    operation.addLast(list);
                    break;
                case 3:
                    operation.displayAll(list);
                    break;
                case 4:
                    operation.writeAllItemsToFile(input, list);
                    break;
                case 5:
                    operation.searchByCode(list);
                    break;
                case 6:
                    operation.deleteByCode(list);
                    break;
                case 7:
                    //operation.sortByCode(list);
                    operation.sort(list.head, list.tail);
                    break;
                case 8:
                    System.out.println(operation.convertToBinary(list.head.info.quantity));
                    break;
                case 9:
                    myStack.clear();
                    operation.getAllItemsFromFile(input, myStack);
                    operation.displayAll(myStack);
                    break;
                case 10:
                    myQueue.clear();
                    operation.getAllItemsFromFile(input, myQueue);
                    operation.displayAll(myQueue);
                    break;
                case 0:
                    stop = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (stop);
    }

    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }


}
