import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeString1 = scanner.nextLine();
        String timeString2 = scanner.nextLine();

        int timeInSeconds1 = LocalTime.parse(timeString1).toSecondOfDay();
        int timeInSeconds2 = LocalTime.parse(timeString2).toSecondOfDay();
        System.out.println(Math.abs(timeInSeconds1 - timeInSeconds2));
    }
}