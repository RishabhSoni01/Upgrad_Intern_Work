package org.example.api;

import org.example.api.Book;

public class APIResponseParser {
    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */

    private static String parse(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule, startIndex);
        return response.substring(startIndex, endIndex);
    }

    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<"; // Default end rule
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        String author = parse(response, "<name>", "</name>");
        book.setAuthor(author);
//
        // Extracting publication year
        String publicationYearStr = parse(response, "<original_publication_year type=\"integer\">", "</original_publication_year>");
        int publicationYear = Integer.parseInt(publicationYearStr.replaceAll(",", ""));
        book.setPublicationYear(publicationYear);
//
//        // Extracting average rating
        double averageRating = Double.parseDouble(parse(response, "<average_rating>", "</average_rating>"));
        book.setAverageRating(averageRating);
//
//        // Extracting ratings count and stripping commas
        String ratingsCountStr = parse(response, "<ratings_count type=\"integer\">", "</ratings_count>");
        int ratingsCount = Integer.parseInt(ratingsCountStr.replaceAll(",", ""));
        book.setRatingsCount(ratingsCount);

        // Extracting image URL
        String imageUrl = parse(response, "<image_url>", "</image_url>");
        book.setImageUrl(imageUrl);

        // Your code
        return book;
    }

    // write overloaded parse method with the 3 parameters response, startRule, endRule
    public static void main(String[] args) {
        String response = "<work>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<average_rating>3.79</average_rating>" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "<image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<best_book type=\"Book\">" +
                "<id></id>" +
                "<author>" +
                "<id></id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url></image_url>" +
                "<small_image_url></small_image_url>" +
                "</best_book>" +
                "<image_url>http://images.gr-assets.com/books/1465675526s/16902.jpg</image_url>" +
                "</work>";
        Book parsedBook = APIResponseParser.parse(response);
        System.out.println(parsedBook.getTitle());
        System.out.println(parsedBook.getAuthor());
        System.out.println(parsedBook.getPublicationYear());
         System.out.println(parsedBook.getAverageRating());
         System.out.println(parsedBook.getRatingsCount());
         System.out.println(parsedBook.getImageUrl());
    }
}
