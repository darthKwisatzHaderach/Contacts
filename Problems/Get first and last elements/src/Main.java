import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // write a method here
    public static int[] getFirstAndLast(int[] array) {
        int firstElement = array[0];
        int lastElement = array[array.length - 1];

        return new int[]{firstElement, lastElement};
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}