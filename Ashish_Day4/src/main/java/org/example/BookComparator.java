package org.example;

import org.example.SetDemo;

import java.util.Comparator;
import java.util.Objects;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        try {
            Objects.requireNonNull(book1);
            Objects.requireNonNull(book2);

            int yearComparison = Integer.compare(book1.getYear(), book2.getYear());
            if (yearComparison != 0) {
                return yearComparison;
            } else {
                return book1.getTitle().compareTo(book2.getTitle());
            }
        } catch (NullPointerException e) {
            System.err.println("Null book encountered during comparison: " + e.getMessage());
            return 0;
        }
    }
}