import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import java.util.HashSet;
import java.util.stream.*;
/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {
	
	private final int UPPER_BOUND = Integer.MAX_VALUE; // used for ids minus one to prevent overflow
	private Set<Contact> contacts;
	private Set<Meeting> meetings;
	
	private int highestContactId;
	private boolean contactsFull;

	private int highestMeetingId;
	private boolean meetingsFull;

	public ContactManagerImpl() {
		contacts = new HashSet<Contact>();
		meetings = new HashSet<Meeting>();
		highestContactId = calculateHighestContactId();
		contactsFull = (highestContactId < UPPER_BOUND) ? false : true;
		highestMeetingId = calculateHighestMeetingId();
		meetingsFull = (highestMeetingId < UPPER_BOUND) ? false : true;
	}

	//Helper methods for adding new Contacts
	private int calculateHighestContactId() {
		Optional<Contact> maxContact = contacts.stream().max((e1, e2) -> e1.getId() - e2.getId());
		if(maxContact.isPresent()) {
			return maxContact.get().getId();
		}
		else {
			return 0;
		}
	}

	private int getHighestContactId() {
		return highestContactId;
	}

	private void incrementHighestContactId() {
		highestContactId++;
		if(highestContactId == UPPER_BOUND) {
			contactsFull = true;
		}
	}

	//Helper functions for adding new Meetings
	private int calculateHighestMeetingId() {
		Optional<Meeting> maxMeeting = meetings.stream().max((e1, e2) -> e1.getId() - e2.getId());
		if(maxMeeting.isPresent()) {
			return maxMeeting.get().getId();
		}
		else {
			return 0;
		}
	}

	private int getHighestMeetingId() {
		return highestMeetingId;
	}

	private void incrementHighestMeetingId() {
		highestMeetingId++;
		if(highestMeetingId == UPPER_BOUND) {
			meetingsFull = true;
		}
	}

	/**
	* Add a new meeting to be held in the future.
	*
	* An ID is returned when the meeting is put into the system. This
	* ID must be positive and non-zero.
	*
	* @param contacts a list of contacts that will participate in the meeting
	* @param date the date on which the meeting will take place
	* @return the ID for the meeting
	* @throws IllegalArgumentException if the meeting is set for a time
	* in the past, of if any contact is unknown / non-existent.
	* @throws NullPointerException if the meeting or the date are null
	* @throws IndexOutOfBoundsException if it is not possible to add more meetings
	*/
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		int newMeetingId = 0;
		if(meetingsFull) {
			throw new IndexOutOfBoundsException();
		}
		else {
			newMeetingId = (getHighestMeetingId() + 1);
			incrementHighestMeetingId();
		}
		meetings.add(new FutureMeetingImpl(newMeetingId, date, contacts));
		return newMeetingId;
	}
	
	/**
	* Returns the PAST meeting with the requested ID, or null if it there is none.
	*
	* The meeting must have happened at a past date.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalStateException if there is a meeting with that ID happening
	* in the future
	*/
	public PastMeeting getPastMeeting(int id) {
		return null;
	}
	
	/**
	* Returns the FUTURE meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening
	* in the past
	*/
	public FutureMeeting getFutureMeeting(int id) {
		return null;
	}
	
	/**
	* Returns the meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	*/
	public Meeting getMeeting(int id) {
		return null;
	}
	
	/**
	* Returns the list of future meetings scheduled with this contact.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the users contacts
	* @return the list of future meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	* @throws NullPointerException if the contact is null
	*/
	public List<Meeting> getFutureMeetingList(Contact contact) {
		return null;
	}
	
	/**
	* Returns the list of meetings that are scheduled for, or that took
	* place on, the specified date
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param date the date
	* @return the list of meetings
	* @throws NullPointerException if the date are null
	*/
	public List<Meeting> getMeetingListOn(Calendar date) {
		return null;
	}
	
	/**
	* Returns the list of past meetings in which this contact has participated.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the users contacts
	* @return the list of future meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	* @throws NullPointerException if the contact is null
	*/
	public List<PastMeeting> getPastMeetingListFor(Contact contact) {
		return null;
	}
	
	/**
	* Create a new record for a meeting that took place in the past.
	*
	* @param contacts a list of participants
	* @param date the date on which the meeting took place
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the list of contacts is
	*		  empty, or any of the contacts does not exist
	* @throws NullPointerException if any of the arguments is null
	*/
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
		return;
	}
	
	/**
	* Add notes to a meeting.
	*
	* This method is used when a future meeting takes place, and is
	* then converted to a past meeting (with notes) and returned.
	*
	* It can be also used to add notes to a past meeting at a later date.
	*
	* @param id the ID of the meeting
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the meeting does not exist
	* @throws IllegalStateException if the meeting is set for a date in the future
	* @throws NullPointerException if the notes are null
	*/
	public PastMeeting addMeetingNotes(int id, String text) {
		return null;
	}
	
	/**
	* Create a new contact with the specified name and notes.
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @return the ID for the new contact
	* @throws IllegalArgumentException if the name or the notes are empty strings
	* @throws NullPointerException if the name or the notes are null
	* @throws IndexOutOfBoundsException if no more contacts can be added
	*/
	public int addNewContact(String name, String notes) {
		int newContactId = 0;
		if(name.equals("") || notes.equals("")) {
			throw new IllegalArgumentException();
		}
		if(contactsFull) {
			throw new IndexOutOfBoundsException();
		}
		else {
			newContactId = (getHighestContactId() + 1);
			incrementHighestContactId();
		}
		contacts.add(new ContactImpl(newContactId, name, notes));
		return newContactId;
	}

	/* - remove, no longer needed after refactoring
	// Private method to check whether a contact exists with the specified id
	private boolean contactIdExists(int someId) {
		Stream contactStream = contacts.stream().filter(e -> e.getId() == someId);
		long numMatchingIds = contactStream.count();
		//System.out.println(numMatchingIds); //debug
		return (numMatchingIds > 0L);
	}
	*/
	
	/**
	* Returns a list with the contacts whose name contains that string.
	*
	* If the string is the empty string, this methods returns the set
	* that contains all current contacts.
	*
	* @param name the string to search for
	* @return a list with the contacts whose name contains that string.
	* @throws NullPointerException if the parameter is null
	*/
	public Set<Contact> getContacts(String name) {
		if(name == null) {
			throw new NullPointerException();
		}
		Set<Contact> returnSet = contacts.stream().filter(e -> {
			//check whether name contains substring //debug
			//boolean returnBool = e.getName().matches(".*" + name + ".*");
			//if(returnBool) {
			//	System.out.println(e.getName());
			//}
			return e.getName().matches(".*" + name + ".*");
		}).collect(Collectors.toSet());
		return returnSet;
	}
	
	/**
	* Returns a list containing the contacts that correspond to the IDs.
	* Note that this method can be used to retrieve just one contact by passing only one ID.
	*
	* @param ids an arbitrary number of contact IDs
	* @return a list containing the contacts that correspond to the IDs.
	* @throws IllegalArgumentException if no IDs are provided or if
	* any of the provided IDs does not correspond to a real contact
	*/
	public Set<Contact> getContacts(int... ids) {
		if(ids == null) {
			throw new NullPointerException();
		}
		if(ids.length == 0) {
			throw new IllegalArgumentException();
		}
		//List<Integer> idList = Arrays.asList(ids); //debug
		Set<Contact> returnSet = contacts.stream().filter(e -> {
			boolean inContacts = false;
			for(int i=0; i < ids.length; i++) {
				if(ids[i] == e.getId()) {
					inContacts = true;
				}
			}
			return inContacts;
		}).collect(Collectors.toSet());
		if(returnSet.size() < ids.length) { //some contacts don't exist
			throw new IllegalArgumentException();
		}
		return returnSet;
	}
	
	/**
	* Save all data to disk.
	*
	* This method must be executed when the program is
	* closed and when/if the user requests it.
	*/
	public void flush() {
		return;
	}
}
