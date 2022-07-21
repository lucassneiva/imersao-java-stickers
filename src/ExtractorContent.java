import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorContent {

    public List<Content> extractContent(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        List<Content> allContent = new ArrayList<>();

        for (Map<String, String> attr : attributeList) {
            String urlImg = attr.get("image");
            String title = attr.get("title");
            Content content = new Content(title, urlImg);

            allContent.add(content);
        }

        return allContent;
    }

}
