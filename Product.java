/**
 * Product class
 */
public class Product {
    String bcode;
    String title;
    Integer quantity;
    double price;
    /**
     * default constructor
     */
    Product() {
    }
    /**
     * Constructor method to initialize a product
     */
    Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    /**
     * convert this product to string to display
     */
    @Override
    public String toString() {
        return bcode + "," + title + "," + quantity + "," + price;
    }
}
