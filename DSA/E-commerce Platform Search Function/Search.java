public class Search {

    public static void linearSearch(Product[] products, int key) {

        for (Product product : products) {

            if (product.productId == key) {

                System.out.println("Product Found using Linear Search:");
                product.display();
                return;
            }
        }

        System.out.println("Product Not Found.");
    }


    public static void binarySearch(Product[] products, int key) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == key) {

                System.out.println("Product Found using Binary Search:");
                products[mid].display();
                return;
            }

            if (products[mid].productId < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Product Not Found.");
    }
}