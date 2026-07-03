import java.util.ArrayList;

public class Inventory {

    ArrayList<Product> inventory = new ArrayList<>();

    public void addProduct(Product p) {
        inventory.add(p);
        System.out.println("Product Added Successfully.");
    }
    public void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }

        System.out.println("\nProductID\tName\t\tQuantity\tPrice");

        for (Product p : inventory) {
            p.display();
        }
    }

    public void searchProduct(int id) {

        for (Product p : inventory) {

            if (p.productId == id) {
                System.out.println("\nProduct Found:");
                p.display();
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    public void updateProduct(int id, String name, int qty, double price) {

        for (Product p : inventory) {

            if (p.productId == id) {

                p.productName = name;
                p.quantity = qty;
                p.price = price;

                System.out.println("Product Updated Successfully.");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    public void deleteProduct(int id) {

        for (int i = 0; i < inventory.size(); i++) {

            if (inventory.get(i).productId == id) {

                inventory.remove(i);

                System.out.println("Product Deleted Successfully.");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }
}