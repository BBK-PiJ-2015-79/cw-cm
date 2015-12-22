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

	@Test(expected = NullPointerException.class)
	public void testTwoArgConsThrowsNPEOnSecondArg() {
		testContact = new ContactImpl(1, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThreeArgConsThrowsIAEOnFirstArg() {
		testContact = new ContactImpl(0, "Testy Testerson", "Some notes");
	}

	@Test(expected = NullPointerException.class)
	public void testThreeArgConsThrowsNPEOnSecondArg() {
		testContact = new ContactImpl(1, null, "Some notes");
	}

	@Test(expected = NullPointerException.class)
	public void testThreeArgConsThrowsNPEOnThirdArg() {
		testContact = new ContactImpl(1, "Testy Testerson", null);
	}

	@Test
	public void testIdSetCorrectlyWithTwoArgCons() {
		testContact = new ContactImpl(543, "Arthur Test");
		assertEquals(543, testContact.getId());
	}

	@Test
	public void testNameSetCorrectlyWithTwoArgCons() {
		testContact = new ContactImpl(543, "Arthur Test");
		assertEquals("Arthur Test", testContact.getName());
	}

	@Test
	public void testIdSetCorrectlyWithThreeArgCons() {
		testContact = new ContactImpl(543, "Arthur Test", "Some notes");
		assertEquals(543, testContact.getId());
	}

	@Test
	public void testNameSetCorrectlyWithThreeArgCons() {
		testContact = new ContactImpl(543, "Arthur Test", "Some notes");
		assertEquals("Arthur Test", testContact.getName());
	}

	@Test
	public void testNotesSetCorrectlyWithThreeArgCons() {
		testContact = new ContactImpl(543, "Arthur Test", "Some notes");
		assertEquals("Some notes", testContact.getNotes());
	}

	@Test
	public void testAddNotesAfterTwoArgumentConstructor() {
		testContact = new ContactImpl(8615, "James Test");
		assertEquals("", testContact.getNotes());
		testContact.addNotes("some notes");
		assertEquals("some notes", testContact.getNotes());
		testContact.addNotes("more notes");
		assertEquals("some notesmore notes", testContact.getNotes());
	}
}
