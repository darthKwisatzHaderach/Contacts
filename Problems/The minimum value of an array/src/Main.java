import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringSize = scanner.nextLine();
        int size = Integer.valueOf(stringSize);

        int[] array = new int[size];
        String str = scanner.nextLine();
        String[] stringsArray = str.split(" ");

        for (int i = 0; i < size; i++) {
            array[i] = Integer.valueOf(stringsArray[i]);
        }

        System.out.println(Arrays.stream(array).min().getAsInt());
    }
}