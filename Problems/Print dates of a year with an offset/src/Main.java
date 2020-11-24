import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        scanner.close();

        int dayOfYear = date.getDayOfYear();
        int daysInYear = date.lengthOfYear();

        for (int i = 0; i <= daysInYear - dayOfYear; i = i + offset) {
            System.out.println(date.plusDays(i));
        }
    }
}