public class Main {

    public static void main(String[] args) {

        Inventory obj = new Inventory();

        obj.addProduct(new Product(101, "Laptop", 15, 50000));
        obj.addProduct(new Product(102, "Mouse", 50, 600));
        obj.addProduct(new Product(103, "Keyboard", 25, 1200));

        obj.displayProducts();

        obj.searchProduct(102);

        obj.updateProduct(102, "Gaming Mouse", 45, 850);

        obj.displayProducts();

        obj.deleteProduct(101);

        obj.displayProducts();
    }
}