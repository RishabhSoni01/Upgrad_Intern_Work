package org.example.Question4;

import org.example.Question4.Book;
import org.example.Question4.PubDateAscComparator;
import org.example.Question4.PubDateDescComparator;

import java.util.*;

public class SetDemo {
    public Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }

        // Adding books
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
        SetDemo demo = new SetDemo();

        // Test case i: Using natural ordering (null comparator)
        Set<Book> result1 = demo.treeSetDemo(null);
        System.out.println("Test case i:");
        for (Book book : result1) {
            System.out.println(book);
        }

        // Test case ii: Using PubDateAscComparator
        Set<Book> result2 = demo.treeSetDemo(new PubDateAscComparator());
        System.out.println("\nTest case ii:");
        for (Book book : result2) {
            System.out.println(book);
        }

        // Test case iii: Using PubDateDescComparator
        Set<Book> result3 = demo.treeSetDemo(new PubDateDescComparator());
        System.out.println("\nTest case iii:");
        for (Book book : result3) {
            System.out.println(book);
        }
    }
}
