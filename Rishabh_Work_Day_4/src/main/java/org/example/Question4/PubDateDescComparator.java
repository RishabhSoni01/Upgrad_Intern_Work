package org.example.Question4;

import org.example.Question4.Book;

import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        // First compare by publication year in descending order
        int result = Integer.compare(b2.getYear(), b1.getYear());
        if (result != 0) {
            return result;
        }
        // If publication year is the same, then compare by title in ascending order
        return b1.getTitle().compareTo(b2.getTitle());
    }
}
