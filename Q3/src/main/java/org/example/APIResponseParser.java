package org.example;
import org.example.Book;


public class APIResponseParser {
    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "</title>";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        endRule="</name>";
        startRule="<name>";
        String author =parse(response,startRule,endRule);
        book.setAuthor(author);

        endRule="</original_publication_year>";
        startRule="<original_publication_year";
        String publicationYear=parse(response,startRule,endRule);
        publicationYear.replaceAll("[^0-9]","");
        book.setPublicationYear(Integer.parseInt(publicationYear));

        startRule="<average_rating";
        endRule="</average_rating>";
        String averageRating =parse(response,startRule,endRule);
        averageRating.replaceAll("[^0-9]","");
        book.setAverageRating(Double.parseDouble(averageRating));

        startRule="<ratings_count";
        endRule="</ratings_count>";
        String ratingsCount=parse(response,startRule,endRule);
        ratingsCount=ratingsCount.replaceAll("[^0-9]","");

        book.setRatingsCount(Integer.parseInt(ratingsCount));

        startRule="<image_url>";
        endRule="</image_url>";
        String imageUrl=parse(response,startRule,endRule);
        book.setImageUrl(imageUrl);
// Your code
        return book;
        // write overloaded parse method with the 3 parameters response,
        //startRule, endRule

        }

        public static String parse(String response,String startRule,String endRule){

        System.out.println("executes");
        int sti = response.indexOf(startRule);
        int eni = response.indexOf(endRule);

        String ans ="";
        int f=0;
        for(int i=sti;i<eni;i++){
            if(f==1){
                ans+=response.charAt(i);
            }else if(response.charAt(i)=='>')f=1;
        }
        System.out.println("execution completed");
        return ans;
        }


    public static void main(String[] args) {
        String response = "<work>\n" +
                "\t<id type=\"integer\">2361393</id>\n" +
                "\t<books_count type=\"integer\">813</books_count>\n" +
                "\t<ratings_count type=\"integer\">1,16,315</ratings_count>\n" +
                "\t<text_reviews_count type=\"integer\">3439</text_reviews_count> <original_publication_year type=\"integer\">1854</original_publication_year> <original_publication_month type=\"integer\" nil=\"true\"/> <original_publication_day type=\"integer\" nil=\"true\"/> <average_rating>3.79</average_rating>\n" +
                "\t<best_book type=\"Book\">\n" +
                "\t<id type=\"integer\">16902</id> <title>Walden</title> <author>\n" +
                "\t<id type=\"integer\">10264</id>\n" +
                "\t<name>Henry David Thoreau</name> </author>\n" +
                "\t   <image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>\n" +
                "\t   <small_image_url>http://images.gr-assets.com/books/1465675526s/16902.jpg</small_image_url>\n" +
                "\t      </best_book>\n" +
                " </work>" ;

        //System.out.println(response);

        Book obj = APIResponseParser.parse(response);

        System.out.println("title: "+obj.getTitle()+","+"author: "+obj.getAuthor()+","+"publication_year: "+obj.getPublicationYear()+","+"averageRating: "+obj.getaverageRating()+","+"ratingcount: "+obj.getRatingsCount()+"," + "imageURL: "+obj.getImageUrl());

    }
}
