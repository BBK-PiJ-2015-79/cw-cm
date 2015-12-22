/**
* A class implementing the Contact interface.
*
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
	/**
	 * Two parameter constructor for objects of type ContactImpl. Constructs an object of type
	 * ContactImpl with an empty string as the contact notes.
	 *
	 * @param id the id of the contact
	 * @param name of the contact
	 * @throws IllegalArgumentException if the id passed as a parameter is zero or less than zero
	 * @throws NullPointerException if the name passed as a parameter is null
	 */
	public ContactImpl(int id, String name) {
		this(id, name, "");
	}
	/**
	 * Three parameter constructor for objects of type ContactImpl. Constructs an object of type
	 * ContactImpl with an initial note specified.
	 *
	 * @param id the id of the contact
	 * @param name of the contact
	 * @throws IllegalArgumentException if the id passed as a parameter is zero or less than zero
	 * @throws NullPointerException if the name passed as a parameter is null
	 */
	public ContactImpl(int id, String name, String contactNotes) {
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
