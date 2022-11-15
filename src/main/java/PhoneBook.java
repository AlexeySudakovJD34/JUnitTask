import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    protected Map<String, List<Contact>> contactsMap = new HashMap<>();

    public void addContactToGroup(String groupName, Contact newContact) {
        if (contactsMap.containsKey(groupName)) {
            List<Contact> editList = contactsMap.get(groupName);
            editList.add(newContact);
            contactsMap.put(groupName, editList);
        } else {
            List<Contact> newList = new ArrayList<>();
            newList.add(newContact);
            contactsMap.put(groupName, newList);
        }
    }

    public void getContactsByGroup(String groupName) {
        if (contactsMap.containsKey(groupName)) {
            System.out.println("Контакты группы " + groupName + ":");
            for (Contact contact : contactsMap.get(groupName)) {
                System.out.format("%10s%15s\n", contact.getName(), contact.getPhone());
            }
        } else {
            System.out.println("Такая группа контактов отсутствует");
        }
    }

    public void showContactByPhone(String phone) {
        boolean searchingFailure = true;
        for (String groupName : contactsMap.keySet()) {
            List<Contact> listForSearching = contactsMap.get(groupName);
            for (Contact cont : listForSearching) {
                if (cont.getPhone().equals(phone)) {
//          System.out.println("В групе " + groupName + " обнаружен контакт:");
                    System.out.println(cont.toString());
                    searchingFailure = false;
                    return; // Выходим из метода при первом совпадении контакта, дальше не ищем
                }
            }
        }
        if (searchingFailure) {
            System.out.println("В записной книге отсутсвует контакт с тел. " + phone);
        }
    }

    public Contact getContactByPhone(String phone) {
        Contact getContact = new Contact("NoRecord", "NoRecord");
        for (String groupName : contactsMap.keySet()) {
            List<Contact> listForSearching = contactsMap.get(groupName);
            for (Contact cont : listForSearching) {
                if (cont.getPhone().equals(phone)) {
                    getContact = cont;
                }
            }
        }
        return getContact;
    }

    public String getNameByPhone(String phone) {
        String name = "NoRecord";
        for (String groupName : contactsMap.keySet()) {
            List<Contact> listForSearching = contactsMap.get(groupName);
            for (Contact cont : listForSearching) {
                if (cont.getPhone().equals(phone)) {
                    name = cont.getName();
                }
            }
        }
        return name;
    }

    @Override
    public String toString() {
        return contactsMap.toString();
    }
}
