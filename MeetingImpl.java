import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;
/**
* Implementation of the Meeting interface. A class to represent meetings
*
* Meetings have unique IDs, scheduled date and a list of participating contacts
*
* @author Chris Grocott
*/
public abstract class MeetingImpl implements Meeting, Serializable {
	private int id;
	private Calendar date;
	private Set<Contact> contacts;

	/**
	 * Constructor for MeetingImpl objects. If the date or contacts parameter is null
	 * then a NullPointerException is thrown. If the contacts list is empty then an
	 * IllegalArgumentException is thrown.
	 *
	 * @param id the id of the meeting
	 * @param date the date of the meeting
	 * @param contacts a list of the contacts attending the meeting
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public MeetingImpl(int id, Calendar date, Set<Contact> contacts) {
		if(date == null || contacts == null) {
			throw new NullPointerException();
		}
		else if((id < 1) || contacts.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.date = date;
		this.contacts = contacts;
	}
	/**
	* Returns the id of the meeting.
	*
	* @return the id of the meeting.
	*/
	@Override
	public int getId() {
		return id;
	}
	/**
	* Return the date of the meeting.
	*
	* @return the date of the meeting.
	*/
	@Override
	public Calendar getDate() {
		return date;
	}
	/**
	* Return the details of people that attended the meeting.
	*
	* The list contains a minimum of one contact (if there were
	* just two people: the user and the contact) and may contain an
	* arbitrary number of them.
	*
	* @return the details of people that attended the meeting.
	*/
	@Override
	public Set<Contact> getContacts() {
		return contacts;
	}
}
