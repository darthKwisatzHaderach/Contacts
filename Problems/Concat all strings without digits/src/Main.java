import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string);
        }

        for (int i = 0; i < stringBuilder.length();) {
            if (Character.isDigit(stringBuilder.charAt(i))) {
                stringBuilder.deleteCharAt(i);
            } else {
                i++;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}