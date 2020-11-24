public class Main {

    public static void main(String[] args) {
        Secret[] secrets = Secret.values();
        int count = 0;

        for (Secret secret : secrets) {
            if (secret.name().startsWith("STAR")) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}

// At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}