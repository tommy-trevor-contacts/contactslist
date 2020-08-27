import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApp {
    static String contactsDirectory = "db";
    static String contactsData = "contacts.txt";
    //Pathway to the contacts text file
//    Path contact = Paths.get("./src/db", "contacts.txt");
    static Path contactsFilePath = Paths.get("./src/" + contactsDirectory + "/" + contactsData);
    //declares contacts array list
//    static List<String> contacts;
    static List<String> contactsList = new ArrayList<>();
    //read content of contacts & add into contacts list array
    if (Files.exists(contactsFilePath)) {
        try {
            contactsList = Files.readAllLines(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void contactInterface() {


        switch (userInput) {
            case 1:


        }

    }

}
