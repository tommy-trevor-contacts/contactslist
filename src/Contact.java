import java.util.ArrayList;
import java.util.List;
public class Contact {
    protected String name;
    protected String phoneNumber;

    // CLASS CONSTRUCTOR
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static List<String> contactToNameStrings(List<Contact> contacts) {
        List<String> names = new ArrayList<>();
        for (Contact contact : contacts) {
            names.add(contact.getName());
        }
        return names;
    }
}
