import java.util.ArrayList;
import java.util.List;
public class Contacts {
    protected String name;
    protected String phoneNumber;
//    protected List<String>


    // CLASS CONSTRUCTOR
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static List<String> contactToNameStrings(List<Contact> contacts) {
        List<String> names = new ArrayList<>();
        for (Contact contact : contacts) {
            names.add(contact.getName());
        }
        return names;
    }
}
