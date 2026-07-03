public class Main {

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101, "John", 1500),
                new Order(102, "David", 800),
                new Order(103, "Alice", 2500),
                new Order(104, "Chris", 1200),
                new Order(105, "Emma", 3000)
        };

        System.out.println("Orders Before Bubble Sort");
        Sorting.display(orders);

        Sorting.bubbleSort(orders);

        System.out.println("Orders After Bubble Sort");
        Sorting.display(orders);

        Order[] orders2 = {

                new Order(101, "John", 1500),
                new Order(102, "David", 800),
                new Order(103, "Alice", 2500),
                new Order(104, "Chris", 1200),
                new Order(105, "Emma", 3000)
        };

        System.out.println("Orders Before Quick Sort");
        Sorting.display(orders2);

        Sorting.quickSort(orders2, 0, orders2.length - 1);

        System.out.println("Orders After Quick Sort");
        Sorting.display(orders2);
    }
}