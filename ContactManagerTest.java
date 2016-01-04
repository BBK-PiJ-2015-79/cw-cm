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
		//System.out.println("Adding, ID is: " + newContactId); //debug
		assertTrue(newContactId > 0);
	}

	// Tests for getting contacts with ids

	@Test
	public void checkGetContactsWithSingleId() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + newContactId); //debug
		Set<Contact> testContactSet = cMTest.getContacts(newContactId);
		assertEquals(1, testContactSet.size());
	}

	@Test
	public void checkGetContactsWithDoubleId() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + newContactId); //debug
		int newContactId2 = cMTest.addNewContact("Tracey Test", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + newContactId2); //debug
		Set<Contact> testContactSet = cMTest.getContacts(newContactId, newContactId2);
		assertEquals(2, testContactSet.size());
	}

	@Test(expected = NullPointerException.class)
	public void checkGetContactsIdThrowsNPEWithNullParam() {
		int[] idArray = null;
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = cMTest.addNewContact("Johnny Danger", "This guy is dangerous");
		//System.out.println("Retrieving, ID is: " + contactIdArray[2]); //debug
		Set<Contact> testContactSet = cMTest.getContacts(idArray);
	}

	// Tests for getting contacts with names

	@Test
	public void checkGetContactsName() {
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = cMTest.addNewContact("Johnny Danger", "This guy is dangerous");
		//System.out.println("Retrieving, ID is: " + contactIdArray[2]); //debug
		Set<Contact> testContactSet = cMTest.getContacts("Test");
		assertEquals(2, testContactSet.size());
	}

	@Test
	public void checkGetContactsWithEmptyString() {
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = cMTest.addNewContact("Johnny Danger", "This guy is dangerous");
		//System.out.println("Retrieving, ID is: " + contactIdArray[2]); //debug
		Set<Contact> testContactSet = cMTest.getContacts("");
		assertEquals(3, testContactSet.size());
	}

	@Test(expected = NullPointerException.class)
	public void checkGetContactsNameThrowsNPEWithNullParam() {
		String testName = null;
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = cMTest.addNewContact("Johnny Danger", "This guy is dangerous");
		//System.out.println("Retrieving, ID is: " + contactIdArray[2]); //debug
		Set<Contact> testContactSet = cMTest.getContacts(testName);
	}

}
