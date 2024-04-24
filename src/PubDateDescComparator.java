import java.util.Comparator;

public class PubDateDescComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getYear() != b2.getYear()) {
            return Integer.compare(b2.getYear(), b1.getYear());
        } else {
            return new TitleComparator().compare(b1, b2);
        }
    }
}
