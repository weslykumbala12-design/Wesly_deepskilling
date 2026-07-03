public class Main {

    public static void main(String[] args) {

        Book[] books = {

                new Book(101, "C Programming", "Dennis Ritchie"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Java Programming", "Herbert Schildt"),
                new Book(104, "Operating Systems", "Galvin"),
                new Book(105, "Python Programming", "Guido")
        };

        System.out.println("Linear Search");
        Search.linearSearch(books, "Java Programming");

        System.out.println();

        System.out.println("Binary Search");
        Search.binarySearch(books, "Java Programming");
    }
}