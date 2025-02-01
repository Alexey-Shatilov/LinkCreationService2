import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UrlShortener {
    private Map<String, String> urlMap = new HashMap<>();
    private Map<String, String> userMap = new HashMap<>();

    public String shortenUrl(String longUrl, String userId) {
        String shortUrl = generateShortUrl(longUrl, userId);
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    private String generateShortUrl(String longUrl, String userId) {
        // Генерация уникального короткого URL
        return "clck.ru/" + UUID.randomUUID().toString().substring(0, 8);
    }
}