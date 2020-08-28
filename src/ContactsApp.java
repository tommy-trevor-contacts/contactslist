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
    public static void main(String[] args) throws IOException {
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

    // Search User Method
    public static List<String> searchContacts(String name) {
        List<String> contactsWithName = new ArrayList<>(); // Make new ArrayList to hold search results
        for (String contact : contactsList) {
            if (contact.toLowerCase().contains(name.toLowerCase())) // Sterilize input and the existing contacts, store anything that contains the user's input into the list
                contactsWithName.add(contact);
        }
        return contactsWithName; // Return the list
    }

    // Add Contact Method
    public static void addContact(String name, String phone) throws IOException {
        Contact contact = new Contact(name, phone);
        contactsList.add(contact.getName() + " | " + contact.getPhoneNumber());
        Files.write(contactsFilePath, contactsList, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Remove user input Contact Method
    public static void removeContact() {
        System.out.println("enter the contact name that you don't want anymore");
        String removeName = scanner.nextLine();
        System.out.println("enter the contact's number that you don't want anymore");
        String removeNumber = scanner.next();
        System.out.println("The contact that will be deleted: " + removeName + " | " + removeNumber);
    }

    //remove contact method
    public static void removeContact(String name) throws IOException {
        for (String contact : contactsList) {
            if (contact.toLowerCase().contains(name.toLowerCase())) { // Sterilize input and the existing contacts, store anything that contains the user's input into the list
                contactsList.remove(contact); break;
            }
        }
        Files.write(contactsFilePath, contactsList, StandardOpenOption.TRUNCATE_EXISTING);
    }

    //This is the void method that is responsible for created the switch cases for user interactions
    public static void contactInterface() throws IOException {
        System.out.println(
                "1. View contacts.\n" +
                        "2. Add a new contact.\n" +
                        "3. Search a contact by name.\n" +
                        "4. Delete an existing contact.\n" +
                        "5. Exit.\n" +
                        "Enter an option (1, 2, 3, 4 or 5):");
        int userInput = Integer.parseInt(scanner.nextLine());
        switch (userInput) {
            case 1: //view all contacts
                System.out.println("\n*** ALL CONTACTS ***");
                viewAll();
                break;
            case 2: //add contact
                System.out.println("\n*** ADD A CONTACT ***");
                System.out.print("\nName: ");
                String contactName = scanner.nextLine(); // get the users desired name
                System.out.print("Phone Number: ");
                String contactPhone = scanner.nextLine(); // get the user desired phone number
                addContact(contactName, contactPhone);
                System.out.println("\nContact added: " + contactName + " | " + contactPhone); // let the user know that their contact was added
                break;
            case 3: // search for a contact
                System.out.println("\n*** SEARCH ***");
                boolean searchAgain = false;
                do {
                    System.out.print("\nName of contact: ");
                    String nameToSearch = scanner.nextLine();

                    List<String> contacts = searchContacts(nameToSearch);

                    if (!contacts.isEmpty()) { // If the list has 1+ elements, display the contacts
                        printContacts(contacts);
                    } else { //
                        System.out.println("\nI'm sorry, a contact by that name does not exist.");
                    }

                    System.out.print("\nWould you like to search the contacts again? [y/n]: "); // prompt the user if they would like to search again

                    String userConfirm = scanner.nextLine();
                    if (userConfirm.toLowerCase().contains("y")) { // if user response contains 'y' re-run search
                        searchAgain = true;
                    } else { // else, do not re-run the loop
                        searchAgain = false;
                    }
                } while (searchAgain);
                break;
            case 4: //remove contact
                System.out.println("\n*** Remove Contact ***");
                System.out.print("\nName: ");
                String removeUser = scanner.nextLine(); // get the users desired name
                removeContact(removeUser);
                System.out.println("\nContact removed: " + removeUser); // let the user know that their contact was added
                break;

        }
    }
}

