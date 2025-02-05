import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LinkShortenerService {
    private final Map<String, ExpiringUrl> urlStore = new HashMap<>();
    private final long defaultLifetime;
    private final int defaultMaxClicks;

    public LinkShortenerService() {
        // Загрузка конфигурации из файла
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
            this.defaultLifetime = Long.parseLong(properties.getProperty("defaultLifetime"));
            this.defaultMaxClicks = Integer.parseInt(properties.getProperty("defaultMaxClicks"));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки конфигурации", e);
        }
    }

    public String shortenLink(String longUrl, String userId) {
        String shortUrl = UrlShortener.generateShortUrl(longUrl);
        urlStore.put(shortUrl, new ExpiringUrl(longUrl, defaultLifetime, defaultMaxClicks, userId));
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        ExpiringUrl expiringUrl = urlStore.get(shortUrl);
        if (expiringUrl != null && expiringUrl.isValid()) {
            expiringUrl.incrementClickCount();
            return expiringUrl.getLongUrl();
        }
        return null;
    }

    public void deleteLink(String shortUrl) {
        urlStore.remove(shortUrl);
    }
}