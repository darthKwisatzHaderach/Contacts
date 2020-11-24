import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        String data = scanner.nextLine();
        int rotation = scanner.nextInt();

        scanner = new Scanner(data);

        do {
            arrayList.add(scanner.nextInt());
        }
        while (scanner.hasNextInt());

        int[] changedArray = new int[arrayList.size()];

        if (arrayList.size() < rotation) {
            rotation = rotation % arrayList.size();
        }

        for (var i = 0; i < arrayList.size(); i++) {
            if (i - rotation < 0) {
                changedArray[i] = (int) arrayList.get(arrayList.size() + i - rotation);
            } else {
                changedArray[i] = (int) arrayList.get(i - rotation);
            }

            System.out.print(changedArray[i] + " ");
        }
    }
}