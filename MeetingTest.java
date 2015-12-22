import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MeetingTest {
	private Meeting testMeeting;

	@Test(expected = IllegalArgumentException.class)
	public void testMeetingThrowsIAEOnFirstParam() {
		testMeeting = new FutureMeetingImpl(0, new GregorianCalendar(), new TreeSet<Contact>());
	}
}
