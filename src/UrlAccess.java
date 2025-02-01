import java.util.concurrent.atomic.AtomicInteger;

public class UrlAccess {
    private String shortUrl;
    private AtomicInteger accessCount;
    private int limit;

    public UrlAccess(String shortUrl, int limit) {
        this.shortUrl = shortUrl;
        this.accessCount = new AtomicInteger(0);
        this.limit = limit;
    }

    public boolean canAccess() {
        return accessCount.get() < limit;
    }

    public void access() {
        if (canAccess()) {
            accessCount.incrementAndGet();
        } else {
            throw new RuntimeException("Link is no longer available.");
        }
    }
}