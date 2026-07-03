public class Search {

    public static void linearSearch(Book[] books, String key) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(key)) {

                System.out.println("Book Found using Linear Search:");
                book.display();
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void binarySearch(Book[] books, String key) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(key);

            if (result == 0) {

                System.out.println("Book Found using Binary Search:");
                books[mid].display();
                return;
            }

            if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Book Not Found.");
    }
}