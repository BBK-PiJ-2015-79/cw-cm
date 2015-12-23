import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MeetingTest {
	private Meeting testMeeting;
	Set<Contact> testContactList;

	@Before
	public void resetTestMeeting() {
		testMeeting = null;
		testContactList = new HashSet<Contact>();
		testContactList.add(new ContactImpl(1, "Testy Testerton"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFutureMeetingConsThrowsIAEOnFirstParam() {
		testMeeting = new FutureMeetingImpl(0, new GregorianCalendar(), testContactList);
	}

	@Test(expected = NullPointerException.class)
	public void testFutureMeetingConsThrowsNPEOnSecondParam() {
		testMeeting = new FutureMeetingImpl(1, null, testContactList);
	}

	@Test(expected = NullPointerException.class)
	public void testFutureMeetingConsThrowsNPEOnThirdParam() {
		testMeeting = new FutureMeetingImpl(1, new GregorianCalendar(), null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFutureMeetingConsThrowsIAEOnThirdParam() {
		testMeeting = new FutureMeetingImpl(1, new GregorianCalendar(), new TreeSet<Contact>());
	}
}
