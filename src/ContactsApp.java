import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {
    static String contactsDirectory = "db";
    static String contactsData = "contacts.txt";
    //Pathway to the contacts text file
    static Path contactsFilePath = Paths.get("./src/" + contactsDirectory + "/" + contactsData).normalize();
    //declares contacts array list
    List<Contact> contact;
    static List<String> contactsList = new ArrayList<>();
    //    static Contact contact;
    static Scanner scanner = new Scanner(System.in);




    // ======= METHODS =======
    //read content of contacts & add into contacts list array
    public static void main(String[] args) {
        try {
            contactsList = Files.readAllLines(contactsFilePath);
            for (String contact : contactsList
            ) {
                System.out.println(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactInterface();
    }



    // Print Contacts
    public static void printContacts(List<String> list) {
        System.out.println("\nName | Phone number");
        System.out.println("---------------");
        for (String contact : list) {
            System.out.println(contact);
        }
    }

    // View All Method
    public static void viewAll() throws IOException {
        contactsList = Files.readAllLines(contactsFilePath);
        printContacts(contactsList);
    }

    //add user input contact method
    public static void addContact() {

        System.out.println("Please Enter New Contact");
        String addName = scanner.nextLine();
        System.out.println("Please enter the contact number");
        String addNumber = scanner.next();
        System.out.println("The contact that will be added: " + addName + " | " + addNumber);
    }

    // Add Contact Method
    public static void addContact(String name, String phone) throws IOException {
        Contact contact = new Contact(name, phone);
        contactsList.add(contact.getName() + " | " + contact.getPhoneNumber());
        Files.write(contactsFilePath, contactsList, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Remove user input Contact Method
    public static void removeContact(){
        System.out.println("enter the contact name that you don't want anymore");
        String removeName = scanner.nextLine();
        System.out.println("enter the contact's number that you don't want anymore");
        String removeNumber = scanner.next();
        System.out.println("The contact that will be deleted: " + removeName + " | " + removeNumber);
    }

    //remove contact method
    public static void  removeCOntact(String name, String phone) throws IOException {
//        contactsList.remove()
    }

    //This is the void method that is responsible for created the switch cases for user interactions
    public static void contactInterface() {
        System.out.println(
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        int userInput = Integer. parseInt(scanner.nextLine());
        switch (userInput) {
            case 1:
                for (String contact : contactsList
                ) {
                    System.out.println(contact);
                }
                break;
            case 2:
                addContact();
                break;
        }
    }
}
