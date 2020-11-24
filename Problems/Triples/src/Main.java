import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.valueOf(scanner.nextLine());
        String[] arrayOfStrings = scanner.nextLine().split(" ");
        Integer[] arrayOfIntegers = new Integer[size];
        int sumOfTriples = 0;

        for (int i = 0; i < size; i++) {
            arrayOfIntegers[i] = Integer.valueOf(arrayOfStrings[i]);
        }

        for (int i = 0; i < size - 2; i++) {
            if ((arrayOfIntegers[i + 1] == arrayOfIntegers[i] + 1) &
                    (arrayOfIntegers[i + 2] == arrayOfIntegers[i] + 2)) {
                sumOfTriples += 1;
            }
        }

        System.out.println(sumOfTriples);
    }
}