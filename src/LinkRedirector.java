import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkRedirector {
    public static void openLink(String longUrl) {
        try {
            Desktop.getDesktop().browse(new URI(longUrl));
        } catch (IOException | URISyntaxException e) {
            System.out.println("Ошибка при открытии ссылки: " + e.getMessage());
        }
    }
}