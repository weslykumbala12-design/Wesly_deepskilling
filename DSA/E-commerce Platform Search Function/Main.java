public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Electronics")
        };

        System.out.println("Linear Search");

        Search.linearSearch(products, 104);

        System.out.println();

        System.out.println("Binary Search");

        Search.binarySearch(products, 104);
    }
}