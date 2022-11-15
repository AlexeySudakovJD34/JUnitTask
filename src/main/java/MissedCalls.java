import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCall(String phone) {
        LocalDateTime dateTime = LocalDateTime.now();
        missedCalls.put(dateTime, phone);
    }

    public void printMissedCalls(PhoneBook phoneBook) {
        System.out.println("Пропущенные звонки:");
        for (LocalDateTime dateTime : missedCalls.keySet()) {
            Contact c = phoneBook.getContactByPhone(missedCalls.get(dateTime));
            if (c.equals(new Contact("NoRecord", "NoRecord"))) {
                System.out.format("%30s%40s\n", dateTime, missedCalls.get(dateTime));
            } else {
                System.out.format("%30s%40s\n", dateTime, c);
            }
        }
    }
}
