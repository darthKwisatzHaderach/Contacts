import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.next();
        int days = scanner.nextInt();
        int hours = scanner.nextInt();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        System.out.println(dateTime.plusDays(days).minusHours(hours));
    }
}