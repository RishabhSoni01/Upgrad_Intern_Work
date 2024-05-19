package org.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.example.Book;
import org.example.BookComparator;




public class SetDemo {
    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books = new TreeSet<>(comparator);

        try {
            // Add books to the set
            books.add(new Book("2 States", "Chetan Bhagat", 2011));
            books.add(new Book("Harry Potter", "J.K. Rowling", 1997));
        } catch (NullPointerException e) {
            System.err.println("Null book encountered while adding to set: " + e.getMessage());
        }

        return books;
    }

    public static void main(String[] args) {
        // Test cases
        Set<Book> result1 = treeSetDemo(null);

        printBooks(result1);

        Set<Book> result2 = treeSetDemo(new BookComparator());

        printBooks(result2);

        Set<Book> result3 = treeSetDemo(new DescendingBookComparator());

        printBooks(result2);
    }

    private static void printBooks(Set<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}