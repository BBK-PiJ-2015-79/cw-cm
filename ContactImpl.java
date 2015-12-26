/**
* A class implementing the Contact interface.
*
* A contact is a person we are making business with or may do in the future.
*
* Contacts have an ID (unique, a non-zero positive integer),
* a name (not necessarily unique), and notes that the user
* may want to save about them.
*
* @author Chris Grocott
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
	@Override
	public int getId() {
		return id;
	}
	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/
	@Override
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
	@Override
	public String getNotes() {
		return contactNotes;
	}
	/**
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	@Override
	public void addNotes(String note) {
		contactNotes = contactNotes + note;
	}

	/**
	 * Check whether the object passed as a parameter is equal to the current Contact.
	 * 
	 * For two Contacts to be equivalent, both must implement the interface Contact and
	 * have the same id.
	 *
	 * @param o the object to be checked for equality.
	 * @return true if the object is an instance of Contact and has the same id as the current Contact
	 */
	@Override
	public boolean equals(Object o) {
		//System.out.println("HELLO: " + o.getClass().getInterfaces().toString()); //debug
		if(o == null || !(o instanceof Contact)) {
			return false;
		}
		//System.out.println("It's a contact... " + this.getName() + " " + ((Contact)o).getName() + " " + (this.getId() == ((Contact)o).getId())); //debug
		return (this.getId() == ((Contact)o).getId());
	}
}
