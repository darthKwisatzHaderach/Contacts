import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?i)password[\\s:]*(\\w+)");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find() == false) {
            System.out.println("No passwords found.");
        } else {
            matcher.reset();
            while (matcher.find()) {
                try {
                    System.out.println(matcher.group(2));
                } catch (Exception e) {
                    System.out.println(matcher.group(1));
                }
            }
        }
    }
}