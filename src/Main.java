import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        LinkShortenerService service = new LinkShortenerService();
        Scanner scanner = new Scanner(System.in);
        String userId = UUID.randomUUID().toString(); // Генерация UUID для пользователя

        while (true) {
            System.out.println("Введите команду (shorten, open, delete, exit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("shorten")) {
                System.out.println("Введите длинный URL:");
                String longUrl = scanner.nextLine();
                String shortUrl = service.shortenLink(longUrl, userId);
                System.out.println("Сокращенная ссылка: " + shortUrl);
            } else if (command.equalsIgnoreCase("open")) {
                System.out.println("Введите короткую ссылку:");
                String shortUrl = scanner.nextLine();
                String longUrl = service.getLongUrl(shortUrl);
                if (longUrl != null) {
                    LinkRedirector.openLink(longUrl);
                } else {
                    System.out.println("Ссылка не найдена или доступ к ней ограничен.");
                }
            } else if (command.equalsIgnoreCase("delete")) {
                System.out.println("Введите короткую ссылку для удаления:");
                String shortUrl = scanner.nextLine();
                service.deleteLink(shortUrl);
                System.out.println("Ссылка удалена: " + shortUrl);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}