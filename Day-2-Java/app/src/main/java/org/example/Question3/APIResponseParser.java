package org.example.Question3;
import org.example.Question3.Book;

public class APIResponseParser {

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        startRule = "<name>";
        String author = parse(response, startRule, endRule);
        book.setAuthor(author);

        startRule = "<original_publication_year";
        endRule = "</original_publication_year>";
        String publicationYearStr = parse(response, startRule, endRule);
        int publicationYear = Integer.parseInt(publicationYearStr);
        book.setPublicationYear(publicationYear);

        startRule = "<average_rating>";
        endRule = "</average_rating>";
        String averageRatingStr = parse(response, startRule, endRule);
        double averageRating = Double.parseDouble(averageRatingStr);
        book.setAverageRating(averageRating);

        startRule = "<ratings_count";
        endRule = "</ratings_count>";
        String ratingsCountStr = parse(response, startRule, endRule).replaceAll(",", "");
        int ratingsCount = Integer.parseInt(ratingsCountStr);
        book.setRatingsCount(ratingsCount);

        startRule = "<image_url>";
        endRule = "</image_url>";
        String imageUrl = parse(response, startRule, endRule);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule);
        if (startIndex == -1) {
            return null;
        }
        startIndex += startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        if (endIndex == -1) {
            return null;
        }
        return response.substring(startIndex, endIndex);
    }


    public static void main(String[] args) {
        String response = "<GoodreadsResponse>\n" +
                "  <book>\n" +
                "    <title>Walden</title>\n" +
                "    <author>\n" +
                "      <name>Henry David Thoreau</name>\n" +
                "    </author>\n" +
                "    <original_publication_year type=\"integer\">1854</original_publication_year>\n" +
                "    <average_rating>3.80</average_rating>\n" +
                "    <ratings_count type=\"integer\">116315</ratings_count>\n" +
                "    <image_url>https://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>\n" +
                "  </book>\n" +
                "</GoodreadsResponse>";

        Book book = APIResponseParser.parse(response);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publication Year: " + book.getPublicationYear());
        System.out.println("Average Rating: " + book.getAverageRating());
        System.out.println("Ratings Count: " + book.getRatingsCount());
        System.out.println("Image URL: " + book.getImageUrl());
    }
}
