package org.example.Question4;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SetDemo {

    public Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book3 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book4 = new Book("The Last Lecture", "Randy Pausch", 2008);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        return books;
    }

    public static void main(String[] args) {
        SetDemo setDemo = new SetDemo();

        System.out.println("Test case i):");
        Set<Book> booksNull = setDemo.treeSetDemo(null);
        for (Book book : booksNull) {
            System.out.println(book.getTitle());
        }

        System.out.println("\nTest case ii):");
        Set<Book> booksAsc = setDemo.treeSetDemo(new PubDateAscComparator());
        for (Book book : booksAsc) {
            System.out.println(book.getTitle());
        }

        System.out.println("\nTest case iii):");
        Set<Book> booksDesc = setDemo.treeSetDemo(new PubDateDescComparator());
        for (Book book : booksDesc) {
            System.out.println(book.getTitle());
        }
    }
}