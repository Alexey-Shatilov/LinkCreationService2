import java.awt.Desktop;
import java.net.URI;

public class LinkRedirector {
    public void redirect(String shortUrl) {
        try {
            Desktop.getDesktop().browse(new URI(shortUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}