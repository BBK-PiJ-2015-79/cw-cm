import java.util.*;
/**
* An implementation of the FutureMeeting interface.
*
* This is a marker class which inherits from MeetingImpl. It adds no new functionality but
* marks the objects of the class as meetings to be held in the future.
*
* @author Chris Grocott
*/
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {
	/**
	 * Constructor for FutureMeetingImpl objects. If the date or contacts parameter is
	 * null then a NullPointerException is thrown. If the contacts list is empty then
	 * an IllegalArgumentException is thrown.
	 *
	 * @param id the id of the meeting
	 * @param date the date of the meeting
	 * @param contacts a list of the contacts attending the meeting
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public FutureMeetingImpl(int id, Calendar date, Set<Contact> contacts) {
		super(id, date, contacts);
	}
}
