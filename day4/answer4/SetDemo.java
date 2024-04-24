import java.util.*;
import org.example.answer4.Book;

public class SetDemo {

    public static class PubDateAscComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {

            int pubDateComparison = Integer.compare(book1.getYear(), book2.getYear());
            if (pubDateComparison != 0) {
                return pubDateComparison;
            }

            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    public static class PubDateDescComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {

            int pubDateComparison = Integer.compare(book2.getYear(), book1.getYear());
            if (pubDateComparison != 0) {
                return pubDateComparison;
            }

            return book1.getTitle().compareTo(book2.getTitle());
        }
    }

    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }


        Book book1 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("The Last Lecture", "Randy Pausch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        return books;
    }

    public static void main(String[] args) {

        Set<Book> result1 = treeSetDemo(null);
        Set<Book> result2 = treeSetDemo(new PubDateAscComparator());
        Set<Book> result3 = treeSetDemo(new PubDateDescComparator());


        System.out.println("Using natural ordering:");
        printBooks(result1);
        System.out.println("\n Using PubDateAscComparator:");
        printBooks(result2);
        System.out.println("\n Using PubDateDescComparator:");
        printBooks(result3);
    }

    public static void printBooks(Set<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
