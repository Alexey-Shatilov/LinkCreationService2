import java.util.Base64;

public class UrlShortener {
    public static String generateShortUrl(String longUrl) {
        // Генерация короткой ссылки на основе Base64
        return Base64.getUrlEncoder().encodeToString(longUrl.getBytes()).substring(0, 8);
    }
}