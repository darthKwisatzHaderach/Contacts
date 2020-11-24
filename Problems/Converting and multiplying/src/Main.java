import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num;
        ArrayList<Object> resultArray = new ArrayList<>();

        do {
            num = scanner.nextLine();
            try {
                if ("0".equals(num)) {
                    scanner.close();
                } else {
                    resultArray.add(Integer.valueOf(num) * 10);
                }
            } catch (NumberFormatException ex) {
                resultArray.add(String.format("Invalid user input: %s", num));
                num = "1";
            }

        } while (Integer.valueOf(num) != 0);

        for (Object element : resultArray) {
            System.out.println(element);
        }
    }
}