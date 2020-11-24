import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        boolean ascending = true;

        for (var i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        for (var i = 1; i < size; i++) {
            if (array[i] < array[i - 1]) {
                ascending = false;
                break;
            }
        }

        System.out.println(ascending);
    }
}