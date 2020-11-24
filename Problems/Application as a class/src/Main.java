class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);

        for (String argument : args) {
            System.out.println(argument);
        }
    }
}