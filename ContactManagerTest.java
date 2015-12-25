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

	@Test
	public void checkAddingNewFutureMeetingReturnsIdGreaterThanZero() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertTrue(newFMeetingId > 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingInPast() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, pastDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkThatNPEThrownWhenCreatingFutureMeetingWithUnknownContact() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(2, "Veronica Testingston"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
	}

}
