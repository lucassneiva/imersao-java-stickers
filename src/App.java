import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String endpoint = "https://api.mocki.io/v2/549a5d8b";

        ClientHttp http = new ClientHttp();
        String json = http.getData(endpoint);

        ExtractorContent extractor =  new ExtractorContent();
        List<Content> allContent = extractor.extractContent(json);

        createSticker creater = new createSticker();
        for (Content content : allContent) {
            
            InputStream inputStream = new URL(content.getUrlImg()).openStream();
            String fileName = content.getTitle()
            .replaceAll(":", "")
            // needs to check if title includes unexpected char
            // .replaceAll("?", "")
            // .replaceAll("<", "")
            // .replaceAll(">", "")
            // .replaceAll("\", "")
            // .replaceAll("/", "")
            // .replaceAll("*", "")
            // .replaceAll('"', '')
            // .replaceAll('|', '')
             + ".png";

            creater.create(inputStream, fileName);
            
            System.out.println(content.get("title"));
            // System.out.println(content.get("image"));
            // System.out.println(content.get("imDbRating"));
            System.out.println();
        }

    }
}
