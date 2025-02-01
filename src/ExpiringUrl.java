import java.util.Timer;
import java.util.TimerTask;

public class ExpiringUrl {
    private String shortUrl;
    private long expirationTime;

    public ExpiringUrl(String shortUrl, long duration) {
        this.shortUrl = shortUrl;
        this.expirationTime = System.currentTimeMillis() + duration;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Логика удаления ссылки
                System.out.println("Link expired: " + shortUrl);
            }
        }, duration);
    }
}