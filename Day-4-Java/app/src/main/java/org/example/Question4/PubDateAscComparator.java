package org.example.Question4;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int pubDateComparison = Integer.compare(book1.getYear(), book2.getYear());
        if (pubDateComparison == 0) {
            return book1.getTitle().compareTo(book2.getTitle());
        }
        return pubDateComparison;
    }
}

