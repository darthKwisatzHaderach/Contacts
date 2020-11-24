import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        System.out.println(dateTime.minusHours(hours).plusMinutes(minutes));
    }
}