/**
* A contact is a person we are making business with or may do in the future.
*
* Contacts have an ID (unique, a non-zero positive integer),
* a name (not necessarily unique), and notes that the user
* may want to save about them.
*/
public class ContactImpl implements Contact {
	private int id;
	private String name;
	private String contactNotes;

	public ContactImpl(int id, String name) {
		this(id, name, "");
	}
	public ContactImpl(int id, String name, String contactNotes) {
		// three argument constructor, empty for now
		if(id < 1) {
			throw new IllegalArgumentException();
		}
		if(name == null || contactNotes == null) {
			throw new NullPointerException();
		}
		this.id = id;
		this.name = name;
		this.contactNotes = contactNotes;
	}
	/**
	* Returns the ID of the contact.
	*
	* @return the ID of the contact.
	*/
	public int getId() {
		return id;
	}
	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/
	public String getName() {
		return name;
	}
	/**
	* Returns our notes about the contact, if any.
	*
	* If we have not written anything about the contact, the empty
	* string is returned.
	*
	* @return a string with notes about the contact, maybe empty.
	*/
	public String getNotes() {
		return contactNotes;
	}
	/**
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	public void addNotes(String note) {
		if(contactNotes == null) {
			contactNotes = note;
		}
		else {
			contactNotes = contactNotes + note;
		}
	}
}
