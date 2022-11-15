import java.util.Objects;

public final class Contact {
    private final String name;
    private final String phone;

    public Contact (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", тел.: " + phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return name.equals(contact.name) && phone.equals(contact.phone);
    }
}
