import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MeetingTest {
	private Meeting testMeeting;
	Set<Contact> testContactList;
	Calendar testDate;

	@Before
	public void resetTestMeeting() {
		testMeeting = null;
		testContactList = new HashSet<Contact>();
		testContactList.add(new ContactImpl(1, "Testy Testerton"));
		testDate = new GregorianCalendar();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFutureMeetingConsThrowsIAEOnFirstParam() {
		testMeeting = new FutureMeetingImpl(0, testDate, testContactList);
	}

	@Test(expected = NullPointerException.class)
	public void testFutureMeetingConsThrowsNPEOnSecondParam() {
		testMeeting = new FutureMeetingImpl(1, null, testContactList);
	}

	@Test(expected = NullPointerException.class)
	public void testFutureMeetingConsThrowsNPEOnThirdParam() {
		testMeeting = new FutureMeetingImpl(1, testDate, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFutureMeetingConsThrowsIAEOnThirdParam() {
		testMeeting = new FutureMeetingImpl(1, testDate, new TreeSet<Contact>());
	}

	@Test
	public void testFutureMeetingReturnsCorrectId() {
		testMeeting = new FutureMeetingImpl(167, testDate, testContactList);
		assertEquals(167, testMeeting.getId());
	}

	@Test
	public void testFutureMeetingReturnsCorrectDate() {
		testMeeting = new FutureMeetingImpl(1274, testDate, testContactList);
		//assertTrue(testDate.equals(testMeeting.getDate()));
		assertTrue(testDate == testMeeting.getDate());
	}

	@Test
	public void testFutureMeetingReturnsCorrectContactList() {
		testMeeting = new FutureMeetingImpl(1274, testDate, testContactList);
		assertTrue(testContactList == testMeeting.getContacts());
	}

	// all of these tests also apply to past meetings
	@Test(expected = IllegalArgumentException.class)
	public void testPastMeetingConsThrowsIAEOnFirstParam() {
		testMeeting = new PastMeetingImpl(0, testDate, testContactList, "");
	}

	@Test(expected = NullPointerException.class)
	public void testPastMeetingConsThrowsNPEOnSecondParam() {
		testMeeting = new PastMeetingImpl(1, null, testContactList, "");
	}

	@Test(expected = NullPointerException.class)
	public void testPastMeetingConsThrowsNPEOnThirdParam() {
		testMeeting = new PastMeetingImpl(1, testDate, null, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPastMeetingConsThrowsIAEOnThirdParam() {
		testMeeting = new PastMeetingImpl(1, testDate, new TreeSet<Contact>(), "");
	}

	@Test
	public void testPastMeetingReturnsCorrectId() {
		testMeeting = new PastMeetingImpl(167, testDate, testContactList, "");
		assertEquals(167, testMeeting.getId());
	}

	@Test
	public void testPastMeetingReturnsCorrectDate() {
		testMeeting = new PastMeetingImpl(1274, testDate, testContactList, "");
		//assertTrue(testDate.equals(testMeeting.getDate()));
		assertTrue(testDate == testMeeting.getDate());
	}

	@Test
	public void testPastMeetingReturnsCorrectContactList() {
		testMeeting = new PastMeetingImpl(1274, testDate, testContactList, "");
		assertTrue(testContactList == testMeeting.getContacts());
	}
}
