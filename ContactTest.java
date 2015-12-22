import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {
	private Contact testContact;
	
	@Before
	public void resetContact() {
		testContact = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTwoArgConsThrowsIAEOnFirstArg() {
		testContact = new ContactImpl(0, "Testy Testerson");
	}
}
