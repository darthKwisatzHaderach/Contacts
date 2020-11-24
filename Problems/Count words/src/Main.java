import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        String str = inputString.trim();
        if (!str.isEmpty()) {
            System.out.println(str.split("\\s+").length);
        } else {
            System.out.println(0);
        }
        reader.close();
    }
}