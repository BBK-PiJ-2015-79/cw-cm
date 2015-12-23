import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ContactManagerTest {
	private ContactManager cMTest;
	private Calendar futureDate;

	@BeforeClass
	public void resetCMTest() {
		cMTest = new ContactManagerImpl();
		futureDate = new GregorianCalendar();
	}

	@Test
	public void checkAddingNewFutureMeetingReturnsIdGreaterThanZero() {
		Set<Contact> contactList = new HashSet<Contact>();
		contactList.add(new ContactImpl(1, "Bill Testman"));
		int newFMeetingId = cMTest.addFutureMeeting(contactList, futureDate);
		assertTrue(newFMeetingId > 0);
	}

}
