import java.util.ArrayList;
import java.util.Collections;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        ArrayList<Integer> arrayOfNumbers = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i < args.length; i++) {
            arrayOfNumbers.add(Integer.valueOf(args[i]));
        }

        switch (operator.toUpperCase()) {
            case "MAX":
                System.out.println(Collections.max(arrayOfNumbers));
                break;
            case "MIN":
                System.out.println(Collections.min(arrayOfNumbers));
                break;
            case "SUM":
                for (int element : arrayOfNumbers) {
                    sum += element;
                }
                System.out.println(sum);
                break;
            default:
                break;
        }
    }
}