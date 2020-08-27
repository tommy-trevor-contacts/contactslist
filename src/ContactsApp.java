import org.w3c.dom.ls.LSOutput;

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
    Contacts = contact


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
    }

    // Add Contact Method
//    public static void addContact () {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter New Contact");
//        String addName = scanner.next();
//
//    }

    public static void addContact(String name, String phone) throws IOException {

        contact = new contact(name, phone);
        contactsList.add(contact.getName() + " | " + contact.getPhoneNumber());

        Files.write(contactsFilePath, contactsList, StandardOpenOption.TRUNCATE_EXISTING);
    }

//    public void contactInterface() {
//        switch (userInput) {
//            case 1:
//        }
//    }
}
