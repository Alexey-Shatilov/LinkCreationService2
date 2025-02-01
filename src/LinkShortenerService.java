import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LinkShortenerService {
    private final Map<String, Link> links = new HashMap<>();

    public String shortenLink(String longUrl, String userId) {
        String shortUrl = generateShortUrl(longUrl, userId);
        links.put(shortUrl, new Link(longUrl, userId));
        return shortUrl;
    }

    private String generateShortUrl(String longUrl, String userId) {
        // Генерация уникальной короткой ссылки
        return "clck.ru/" + UUID.randomUUID().toString().substring(0, 6);
    }

    public String getLongUrl(String shortUrl) {
        Link link = links.get(shortUrl);
        if (link != null) {
            return link.getLongUrl();
        }
        return null; // Ссылка не найдена
    }

    private static class Link {
        private final String longUrl;
        private final String userId;

        public Link(String longUrl, String userId) {
            this.longUrl = longUrl;
            this.userId = userId;
        }

        public String getLongUrl() {
            return longUrl;
        }
    }
}