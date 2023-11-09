import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class WebScrapper {
    public static void main(String[] args) {
        List<String> urlsToScrape = new ArrayList<>();
        urlsToScrape.add("https://www.addteq.com/products/excellentable/");
        urlsToScrape.add("https://www.addteq.com/products/mscgen/");
        urlsToScrape.add("https://www.addteq.com/products/");
        urlsToScrape.add("https://www.addteq.com/products/unstoppable/");
        urlsToScrape.add("https://www.addteq.com/products/graphviz/");

        for (String url : urlsToScrape) {
            try {
                // Send an HTTP GET request to the URL
                Document document = Jsoup.connect(url).get();

                // Extract the data for verification
                String title = document.title();
                String type = document.select("meta[property=og:type]").attr("content");
                String image = document.select("meta[property=og:image]").attr("content");
                String description = document.select("meta[property=og:description]").attr("content");
                String author = document.select("meta[property=og:site_name]").attr("content");
                String publishDate = document.select("meta[property=article:published_time]").attr("content");

                // Print scraped data
                System.out.println("URL: " + url);
                System.out.println("Title: " + title);
                System.out.println("Type: " + type);
                System.out.println("Image: " + image);
                System.out.println("Description: " + description);
                System.out.println("Author: " + author);
                System.out.println("Publish Date: " + publishDate);
                System.out.println();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
