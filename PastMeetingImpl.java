import java.util.*;
/**
* A meeting that was held in the past.
*
* It includes your notes about what happened and what was agreed.
*
* @author Chris Grocott
*/
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes;
	/**
	 * Constructor for PastMeetingImpl objects. If the date, contacts or notes parameter is
	 * null then a NullPointerException is thrown. If the contacts list is empty then
	 * an IllegalArgumentException is thrown.
	 *
	 * @param id the id of the meeting
	 * @param date the date of the meeting
	 * @param contacts a list of the contacts attending the meeting
	 * @param notes the notes attached to the meeting
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public PastMeetingImpl(int id, Calendar date, Set<Contact> contacts, String notes) {
		super(id, date, contacts);
		if(notes == null) {
			throw new NullPointerException();
		}
		this.notes = notes;
	}
	/**
	* Returns the notes from the meeting.
	*
	* If there are no notes, the empty string is returned.
	*
	* @return the notes from the meeting.
	*/
	@Override
	public String getNotes() {
		return notes;
	}
}
