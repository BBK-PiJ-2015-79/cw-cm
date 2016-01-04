import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ContactManagerTest {
	private ContactManager cMTest;
	private Calendar futureDate;
	private Calendar pastDate;

	@Before
	public void resetCMTest() {
		cMTest = new ContactManagerImpl();
		futureDate = new GregorianCalendar(2525, 01, 01);
		pastDate = new GregorianCalendar(1979, 07, 23);

	}

	// Tests for adding contacts
	@Test
	public void checkAddingNewContactReturnsIdGreaterThanZero() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		System.out.println("Adding, ID is: " + newContactId);
		assertTrue(newContactId > 0);
	}

	@Test
	public void checkGetContactsWithSingleId() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		System.out.println("Retrieving, ID is: " + newContactId);
		Set<Contact> testContactSet = cMTest.getContacts(newContactId);
		assertEquals(1, testContactSet.size());
	}

}
