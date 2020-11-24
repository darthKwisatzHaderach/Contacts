package contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static contacts.Actions.ADD;
import static contacts.Actions.AGAIN;
import static contacts.Actions.BACK;
import static contacts.Actions.COUNT;
import static contacts.Actions.DELETE;
import static contacts.Actions.EDIT;
import static contacts.Actions.EXIT;
import static contacts.Actions.LIST;
import static contacts.Actions.MENU;
import static contacts.Actions.RECORD;
import static contacts.Actions.SEARCH;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "C:\\Users\\Dmitriy\\Downloads\\Contacts(default).txt";
        ArrayList<Contact> contacts = new ArrayList<>();
        Actions action;
        Scanner scanner = new Scanner(System.in);

        if (args.length == 1) {
            fileName = args[0];
            ArrayList tempContacts = (ArrayList) SerializationUtils.deserialize(fileName);
            contacts.addAll(tempContacts);
        }

        do {
            System.out.printf("[%s] Enter action (%s, %s, %s, %s, %s):\n", MENU, ADD, LIST, SEARCH, COUNT, EXIT);
            action = Actions.valueOf(scanner.nextLine().toUpperCase());

            switch (action) {
                case ADD: {
                    addContact(contacts, scanner);
                    break;
                }
                case LIST: {
                    printContacts(contacts);
                    System.out.printf("[%s] Enter action([number], %s):\n", LIST, BACK);
                    String stringAction = scanner.nextLine();
                    try {
                        int num = Integer.parseInt(stringAction);
                        Contact contact = contacts.get(num - 1);
                        System.out.println(contact.toString());

                        System.out.printf("[%s] Enter action (%s, %s, %s):\n", RECORD, EDIT, DELETE, MENU);
                        action = Actions.valueOf(scanner.nextLine().toUpperCase());

                        switch (action) {
                            case EDIT:
                                editContact(contact, scanner);
                                break;
                            case DELETE:
                                contacts.remove(contact);
                                break;
                            case MENU:
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        action = Actions.valueOf(stringAction.toUpperCase());
                        if (action == BACK) {
                            break;
                        }
                    }
                    break;
                }
                case SEARCH: {
                    System.out.println("Enter search query:");
                    String searchQuery = scanner.nextLine();
                    ArrayList<Contact> results = new ArrayList<>();
                    for (Contact contact : contacts) {
                        Pattern pattern = Pattern.compile(searchQuery, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(contact.toString());
                        if (matcher.find()) {
                            results.add(contact);
                        }
                    }
                    System.out.printf("Found %d results:\n", results.size());
                    printContacts(results);

                    System.out.printf("[%s] Enter action([number], %s, %s):\n", SEARCH, BACK, AGAIN);
                    String stringAction = scanner.nextLine();
                    try {
                        int num = Integer.parseInt(stringAction);
                        Contact contact = contacts.get(num - 1);
                        System.out.println(contact.toString());

                        System.out.printf("[%s] Enter action (%s, %s, %s):\n", RECORD, EDIT, DELETE, MENU);
                        action = Actions.valueOf(scanner.nextLine().toUpperCase());

                        switch (action) {
                            case EDIT:
                                editContact(contact, scanner);
                                break;
                            case DELETE:
                                contacts.remove(contact);
                                break;
                            case MENU:
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        action = Actions.valueOf(stringAction.toUpperCase());
                        if (action == BACK) {
                            break;
                        }
                    }
                    break;
                }
                case COUNT: {
                    System.out.println("The Phone Book has " + contacts.size() + " records.\n");
                    break;
                }
                case EXIT: {
                    action = EXIT;
                    break;
                }
                default:
                    System.out.printf("[%s] Wrong action. Select action from list: (%s, %s, %s, %s, %s):", MENU, ADD, LIST, SEARCH, COUNT, EXIT);
            }

            SerializationUtils.serialize(contacts, fileName, false);
        }
        while (action != EXIT);
    }

    private static void addContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.println("Enter the type (person, organization):");
        String contactType = scanner.nextLine();
        Contact contact;

        switch (contactType.toLowerCase()) {
            case "person":
                contact = createPersonContact(scanner);
                break;
            case "organization":
                contact = createOrganizationContact(scanner);
                break;
            default:
                System.out.println("Wrong contact type.");
                return;
        }

        contacts.add(contact);
        System.out.println("The record added.\n");
    }

    private static Person createPersonContact(Scanner scanner) {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        if (birthDate.isEmpty()) {
            System.out.println("Bad birth date!");
        }
        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if (gender.isEmpty()) {
            System.out.println("Bad gender!");
        }
        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        return new Person(name, surname, number, birthDate, gender);
    }

    private static Organization createOrganizationContact(Scanner scanner) {
        System.out.println("Enter the organization name:");
        String organizationName = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        return new Organization(organizationName, address, number);
    }

    private static void editContact(Contact contact, Scanner scanner) {
        System.out.printf("Select a field (%s):\n", Arrays.toString(contact.getFields()).replace("[\\[,\\]]", ""));
        Fields field = Fields.valueOf(scanner.nextLine().toUpperCase());
        System.out.printf("Enter %s:", field.getLabel().toLowerCase());
        String newValue = scanner.nextLine();
        contact.changeField(field, newValue);
        System.out.println("Saved");
    }

    private static void printContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append(contacts.indexOf(contact) + 1 + ". ")
                    .append(contact.getFullName());
            System.out.println(stringBuilder);
        }
        System.out.println();
    }
}