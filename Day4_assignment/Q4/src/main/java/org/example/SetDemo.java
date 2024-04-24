package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Book implements Comparable<Book> {
    public String title;
    public String author;
    public int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPubYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }

    // Implement compareTo method for natural ordering by title
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}





public class SetDemo {

    public static void treeSetDemo(List<Book> books, Comparator<Book> comparator) {
        List<Book> sortedBooks = new ArrayList<>(books);

        if (comparator == null) {
            // Use natural ordering (compareTo method of Book class)
            sortedBooks.sort(null);
        } else {
            // Use custom comparator
            sortedBooks.sort(comparator);
        }

        // Print the sorted list of books
        for (Book book : sortedBooks) {
            System.out.println(book);
        }
    }



    public static void main(String args[]){

        List<Book> books = new ArrayList<>();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        Book book4 = new Book("Animal Farm", "George Orwell", 1945);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        treeSetDemo(books,null);
        treeSetDemo(books,new PubDateAscComparator());
        treeSetDemo(books,new PubDateDscComparator());


    }
}

class PubDateAscComparator implements Comparator<Book> {

    public int compare(Book book1, Book book2) {
        int result = Integer.compare(book1.year, book2.year);
        if (result == 0) {
            // If publication years are the same, compare titles in ascending order
            result = book1.title.compareTo(book2.title);
        }
        return result;
    }
}

class PubDateDscComparator implements Comparator<Book>{
    public int compare(Book book1,Book book2){
        int result = Integer.compare(book2.year,book1.year);
        if(result==0){
            result = book1.title.compareTo(book2.title);
        }
        return result;
    }

}
