import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean isComposite(long number) {
        ArrayList<Integer> dividers = new ArrayList<>();

        if (number <= 0) {
            return false;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                dividers.add(i);
            }
        }

        if (dividers.size() < 3) {
            return false;
        }

        return true;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}