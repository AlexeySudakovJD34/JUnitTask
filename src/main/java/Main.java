public class Main {

    public static void main(String[] args) throws Exception {
        Contact cont1 = new Contact("Иван", "89167777777");
        Contact cont2 = new Contact("Алексей", "89265555555");
        Contact cont3 = new Contact("Иван", "89167777777");
        Contact cont4 = new Contact("Начальник", "89062222222");
        Contact cont5 = new Contact("Отец", "89251111111");
        Contact cont6 = new Contact("Сестра", "89263333333");

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.addContactToGroup("Семья", cont5);
        myPhoneBook.addContactToGroup("Семья", cont6);
        myPhoneBook.addContactToGroup("Работа", cont4);
        myPhoneBook.addContactToGroup("Работа", cont1);
        myPhoneBook.addContactToGroup("Работа", cont6);
        myPhoneBook.addContactToGroup("Друзья", cont1);
        myPhoneBook.addContactToGroup("Друзья", cont2);

        System.out.println(myPhoneBook.toString());

        myPhoneBook.getContactsByGroup("Хобби");
        myPhoneBook.getContactsByGroup("Работа");

        myPhoneBook.showContactByPhone("89167777777");
        myPhoneBook.showContactByPhone("89263333333");
        myPhoneBook.showContactByPhone("89263333339");
        System.out.println("Тел. 89265555555 принадлежит: " + myPhoneBook.getNameByPhone("89265555555"));

        MissedCalls lastMissedCalls = new MissedCalls();
        lastMissedCalls.addMissedCall("89601112211");
        Thread.sleep(100);
        lastMissedCalls.addMissedCall("89104448844");
        Thread.sleep(100);
        lastMissedCalls.addMissedCall("89062222222"); //Начальник

        lastMissedCalls.printMissedCalls(myPhoneBook);
    }
}
