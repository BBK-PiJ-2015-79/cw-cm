import java.util.*;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes;
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
	public String getNotes() {
		return notes;
	}
}
