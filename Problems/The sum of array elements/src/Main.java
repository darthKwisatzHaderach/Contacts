import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int sum = 0;

        for (var i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        System.out.println(sum);
    }
}