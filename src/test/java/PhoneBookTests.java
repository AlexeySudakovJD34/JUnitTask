import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class PhoneBookTests {
    PhoneBook sut;

    @BeforeEach
    public void startedEach() {
        System.out.println("test started");
        sut = new PhoneBook();

    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finishedEach() {
        System.out.println("test completed");
        sut = null;
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testAddContactToGroup_GroupNotExist() {
        //arrange
        String expectedGroupName = "Family";
        Contact expectedContact = new Contact("Sister", "+79999999999");
        //act
        sut.addContactToGroup("Family", new Contact("Sister", "+79999999999"));
        //assert
        assertEquals(expectedContact, sut.contactsMap.get(expectedGroupName).get(0));
    }

    @Test
    public void testAddContactToGroup_GroupExists() {
        //arrange
        String expectedGroupName = "Family";
        Contact expectedContact = new Contact("Sister", "+79999999999");
        sut.addContactToGroup("Family", new Contact("Brother", "+79998888888"));
        //act
        sut.addContactToGroup("Family", new Contact("Sister", "+79999999999"));
        //assert
        assertEquals(expectedContact, sut.contactsMap.get(expectedGroupName).get(1));
    }

    @Test
    public void testGetNameByPhone_NameExists() {
        //arrange
        String expectedName = "Brother";
        sut.addContactToGroup("Family", new Contact("Brother", "+79998888888"));
        //act
        String resultName = sut.getNameByPhone("+79998888888");
        //assert
        assertEquals(expectedName, resultName);
    }

    @Test
    public void testGetNameByPhone_NameNotExist() {
        //arrange
        String expectedName = "NoRecord";
        sut.addContactToGroup("Family", new Contact("Brother", "+79998888888"));
        //act
        String resultName = sut.getNameByPhone("+79997777777");
        //assert
        assertEquals(expectedName, resultName);
    }
}

