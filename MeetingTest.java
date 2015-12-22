import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MeetingTest {
	private Meeting testMeeting;

	@Before
	public void resetTestMeeting() {
		testMeeting = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFutureMeetingConsThrowsIAEOnFirstParam() {
		testMeeting = new FutureMeetingImpl(0, new GregorianCalendar(), new TreeSet<Contact>());
	}

	@Test(expected = NullPointerException.class)
	public void testFutureMeetingConsThrowsNPEOnSecondParam() {
		testMeeting = new FutureMeetingImpl(1, null, new TreeSet<Contact>());
	}
}
