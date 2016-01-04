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
	//Tests for adding new FutureMeetings
	@Test
	public void checkAddingNewFutureMeetingReturnsIdGreaterThanZero() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		//System.out.println("Added id: " + newId);
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertTrue(newFMeetingId > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatIAEThrownWhenCreatingFutureMeetingInPast() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, pastDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatIAEThrownWhenCreatingFutureMeetingWithUnknownContact() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(2590438, "Veronica Testingston"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
	}

	@Test(expected = NullPointerException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingWithNullContacts() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		int newFMeetingId = cMTest.addFutureMeeting(null, futureDate);
	}

	@Test(expected = NullPointerException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingWithNullDate() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, null);
	}

	//Tests for getting Meetings

	@Test
	public void checkThatGetMeetingReturnsCorrectMeeting() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertFalse(cMTest.getMeeting(newFMeetingId) == null);
	}

	@Test
	public void checkThatGetMeetingReturnsNullForUnknownMeeting() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertTrue(cMTest.getMeeting(newFMeetingId + 1) == null);
	}

	// Tests for adding new past meetings

	@Test
	public void checkAddingNewPastMeeting() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		cMTest.addNewPastMeeting(contactList, pastDate, "What a great meeting!");
		assertTrue(((PastMeeting)cMTest.getMeeting(1)).getNotes().equals("What a great meeting!"));
	}

	@Test(expected = NullPointerException.class)
	public void checkNPEThrownWhenAddingPastMeetingWithNullContacts() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		cMTest.addNewPastMeeting(null, pastDate, "What a great meeting!");
	}

	@Test(expected = NullPointerException.class)
	public void checkNPEThrownWhenAddingPastMeetingWithNullDate() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		cMTest.addNewPastMeeting(contactList, null, "What a great meeting!");
	}

	@Test(expected = NullPointerException.class)
	public void checkNPEThrownWhenAddingPastMeetingWithNullNotes() {
		int newId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Jimmy Test"));
		cMTest.addNewPastMeeting(contactList, pastDate, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIAEThrownWhenAddingPastMeetingWithEmptyContacts() {
		Set<Contact> contactList = new HashSet<Contact>();
		cMTest.addNewPastMeeting(contactList, pastDate, "Awesome meeting");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIAEThrownWhenAddingPastMeetingWithUnknownContacts() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(999999, "Jimmy Test")); //unknown
		cMTest.addNewPastMeeting(contactList, pastDate, "Awesome meeting");
	}

	// Tests for adding contacts
	@Test
	public void checkAddingNewContactReturnsIdGreaterThanZero() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		//System.out.println("Adding, ID is: " + newContactId); //debug
		assertTrue(newContactId > 0);
	}

	@Test(expected = NullPointerException.class)
	public void checkNPEThrownWhenAddingContactWithNullName() {
		int newContactId = cMTest.addNewContact(null, "This guy is a test");
	}

	@Test(expected = NullPointerException.class)
	public void checkNPEThrownWhenAddingContactWithNullNotes() {
		int newContactId = cMTest.addNewContact("Jimmy Test", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIAEThrownWhenAddingContactWithEmptyName() {
		int newContactId = cMTest.addNewContact("", "This guy is a test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIAEThrownWhenAddingContactWithEmptyNotes() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "");
	}

	@Test(timeout = 10000)
	public void addAMillionConacts() {
		for(int i = 0; i < 1000000; i++) {
			int newContactId = cMTest.addNewContact("Test dude", "Test");
			//System.out.println("Contact " + i + " id: " + newContactId); //debug
		}
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

	@Test(expected = IllegalArgumentException.class)
	public void checkGetContactsIdThrowsIAEWithZeroLengthArray() {
		int[] idArray = new int[0];
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = cMTest.addNewContact("Johnny Danger", "This guy is dangerous");
		//System.out.println("Retrieving, ID is: " + contactIdArray[2]); //debug
		Set<Contact> testContactSet = cMTest.getContacts(idArray);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkGetContactsIdThrowsIAEWithUnknownContact() {
		int[] idArray = new int[0];
		int[] contactIdArray = new int[3];
		contactIdArray[0] = cMTest.addNewContact("Jimmy Tester", "This guy is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[0]); //debug
		contactIdArray[1] = cMTest.addNewContact("Tracey Testington", "This lady is a test");
		//System.out.println("Retrieving, ID is: " + contactIdArray[1]); //debug
		contactIdArray[2] = -1; //non-existant id (can't ever be less than 1)
		Set<Contact> testContactSet = cMTest.getContacts(contactIdArray);
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
