package org.example;

public class Main {
    public Book parse(String response) {
        Book book = new Book();


        String title = parseField(response, "<title>", "</title>");
        book.setTitle(title);


        String author = parseField(response, "<name>", "</name>");
        book.setAuthor(author);


        String pubYearStr = parseField(response, "<original_publication_year type=\"integer\">", "</original_publication_year>");
        if (pubYearStr != null && !pubYearStr.isEmpty()) {
            int publicationYear = Integer.parseInt(pubYearStr);
            book.setPublicationYear(publicationYear);
        }


        String avgRatingStr = parseField(response, "<average_rating>", "</average_rating>");
        if (avgRatingStr != null && !avgRatingStr.isEmpty()) {
            double averageRating = Double.parseDouble(avgRatingStr);
            book.setAverageRating(averageRating);
        }


        String ratingsCountStr = parseField(response, "<ratings_count type=\"integer\">", "</ratings_count>");
        if (ratingsCountStr != null && !ratingsCountStr.isEmpty()) {
            ratingsCountStr = ratingsCountStr.replaceAll(",", ""); // Remove commas from the string
            int ratingsCount = Integer.parseInt(ratingsCountStr);
            book.setRatingsCount(ratingsCount);
        }


        String imageUrl = parseField(response, "<image_url>", "</image_url>");
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parseField(String response, String startRule, String endRule) {
        int startIndex = response.indexOf(startRule);
        if (startIndex == -1) return null;
        startIndex += startRule.length();

        int endIndex = response.indexOf(endRule, startIndex);
        if (endIndex == -1) return null;

        return response.substring(startIndex, endIndex);
    }



    class Book {
        private String title;
        private String author;
        private int publicationYear;
        private double averageRating;
        private int ratingsCount;
        private String imageUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        public void setPublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
        }

        public double getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(double averageRating) {
            this.averageRating = averageRating;
        }

        public int getRatingsCount() {
            return ratingsCount;
        }

        public void setRatingsCount(int ratingsCount) {
            this.ratingsCount = ratingsCount;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}