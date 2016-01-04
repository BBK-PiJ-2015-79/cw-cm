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

	//Tests for adding future meetings

	@Test
	public void checkAddingNewFutureMeetingReturnsIdGreaterThanZero() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertTrue(newFMeetingId > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatIAEThrownWhenCreatingFutureMeetingInPast() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, pastDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatIAEThrownWhenCreatingFutureMeetingWithUnknownContact() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(2590438, "Veronica Testingston"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
	}

	@Test(expected = NullPointerException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingWithNullContacts() {
		int newFMeetingId = cMTest.addFutureMeeting(null, futureDate);
	}

	@Test(expected = NullPointerException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingWithNullDate() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, null);
	}

	//@Test
	//public void addAMillionFutureEvents() {
		//
	//}

	//@Test
	//public void addAMeetingWithAMillionContacts() {
		//
	//	Set<Contact> contactList = new HashSet<Contact>();
	//	for(int i = 1; i <= 1000000; i++) {
	//		contactList.add(new ContactImpl(i, "Test"));
	//	}
	//	int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
	//}

	// Tests for adding contacts
	@Test
	public void checkAddingNewContactReturnsIdGreaterThanZero() {
		int newContactId = cMTest.addNewContact("Jimmy Test", "This guy is a test");
		assertTrue(newContactId > 0);
	}

}
