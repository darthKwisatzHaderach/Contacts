import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        LocalDate firstDayOfMonthInYear = LocalDate.of(year, month, 1);
        int lengthOfMonth = firstDayOfMonthInYear.lengthOfMonth();
        LocalDate lastDayOfMonthInYear = LocalDate.of(year, month, lengthOfMonth);
        System.out.println(firstDayOfMonthInYear + " " + lastDayOfMonthInYear);
    }
}