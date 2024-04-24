package org.example.Question4;
import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int pubDateComparison = Integer.compare(book2.getYear(), book1.getYear());
        if (pubDateComparison == 0) {
            return book1.getTitle().compareTo(book2.getTitle());
        }
        return pubDateComparison;
    }
}