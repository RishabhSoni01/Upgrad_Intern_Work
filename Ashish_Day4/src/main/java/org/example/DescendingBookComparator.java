
package org.example;

import org.example.SetDemo;

import java.util.Comparator;
import java.util.Objects;

public class DescendingBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        try {
            Objects.requireNonNull(book1);
            Objects.requireNonNull(book2);

            // Compare publication years in descending order
            int yearComparison = Integer.compare(book2.getYear(), book1.getYear());

            if (yearComparison != 0) {
                return yearComparison; // If publication years are different, return the comparison result
            } else {
                // If publication years are the same, compare titles in ascending order
                return book1.getTitle().compareTo(book2.getTitle());
            }
        } catch (NullPointerException e) {
            System.err.println("Null book encountered during comparison: " + e.getMessage());
            return 0;
        }
    }
}
