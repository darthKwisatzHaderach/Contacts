import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int offset = scanner.nextInt();

        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = LocalDate.of(year, month, firstDayOfMonth.lengthOfMonth());

        System.out.println(lastDayOfMonth.minusDays(offset - 1));
    }
}