import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] levelsString = line.split(" ");
        int sum = 0;

        for (String levelString : levelsString) {
            Level level = Level.parse(levelString.toUpperCase());
            sum += level.intValue();
        }

        System.out.println(sum);
    }
}