import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> arrayList = new ArrayList<>();
        int current = reader.read();
        while (current != -1) {
            arrayList.add((char) current);
            current = reader.read();
        }
        Collections.reverse(arrayList);
        for (char c : arrayList) {
            System.out.print(c);
        }
        reader.close();
    }
}