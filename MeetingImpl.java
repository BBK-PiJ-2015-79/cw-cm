import java.util.Calendar;
import java.util.Set;
/**
* Implementation of the Meeting interface. A class to represent meetings
*
* Meetings have unique IDs, scheduled date and a list of participating contacts
*/
public abstract class MeetingImpl implements Meeting {
	private int id;

	public MeetingImpl(int id, Calendar date, Set<Contact> contacts) {
		if(date == null || contacts == null) {
			throw new NullPointerException();
		}
		else if((id < 1) || contacts.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}
	/**
	* Returns the id of the meeting.
	*
	* @return the id of the meeting.
	*/
	public int getId() {
		return id;
	}
	/**
	* Return the date of the meeting.
	*
	* @return the date of the meeting.
	*/
	public Calendar getDate() {
		return null;
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
	public Set<Contact> getContacts() {
		return null;
	}
}
