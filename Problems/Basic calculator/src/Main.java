class Problem {

    public static void main(String[] args) {
        String operation = args[0];
        int num1 = Integer.valueOf(args[1]);
        int num2 = Integer.valueOf(args[2]);

        switch (operation) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}