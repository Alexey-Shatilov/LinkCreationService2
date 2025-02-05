import java.time.Instant;

public class ExpiringUrl {
    private String longUrl;
    private long expirationTime;
    private int maxClicks;
    private int clickCount;
    private String userId;

    public ExpiringUrl(String longUrl, long lifetime, int maxClicks, String userId) {
        this.longUrl = longUrl;
        this.expirationTime = Instant.now().toEpochMilli() + lifetime;
        this.maxClicks = maxClicks;
        this.clickCount = 0;
        this.userId = userId;
    }

    public boolean isValid() {
        return clickCount < maxClicks && Instant.now().toEpochMilli() < expirationTime;
    }

    public void incrementClickCount() {
        if (isValid()) {
            clickCount++;
        }
    }

    public String getLongUrl() {
        return longUrl;
    }
}