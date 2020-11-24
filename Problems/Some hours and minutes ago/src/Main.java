import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString = scanner.nextLine();
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        LocalTime time = LocalTime.parse(timeString);
        LocalTime newTime = time.minusHours(hours).minusMinutes(minutes);
        System.out.println(newTime);
    }
}