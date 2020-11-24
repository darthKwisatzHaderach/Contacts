import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeString = scanner.nextLine();
        int minutes = scanner.nextInt();

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        LocalDateTime changedDateTime = dateTime.plusMinutes(minutes);
        System.out.print(changedDateTime.getYear());
        System.out.print(" ");
        System.out.print(changedDateTime.getDayOfYear());
        System.out.print(" ");
        System.out.print(changedDateTime.toLocalTime());
    }
}