package ss.week1.hotel;

/**
 * Hotel guest with name and possibly a room..
 * @author Group 5 (Radu Seteanu & Richard Santing)
 * @version $Revision: 207.23 $
 */

public class Guest {
	// ------------------ Instance variables ----------------
	
	private String name = "";
	private Room room = null; 
	
	// ------------------ Constructor ------------------------

    /**
     * Creates a <code>Guest</code> with the given name, without a room.
     * @param n name of the new <code>Guest</code>
     */
	
	public Guest(String n) {
		name = n;
	}
	
	// ------------------ Commands --------------------------

    /**
     * Assigns a <code>Room</code> to this <code>Guest</code>.
     * @param r the room being rented by this <code>Guest</code>;
     *        if <code>null</code> is passed, this <code>Guest</code>
     *        is homeless
     */
	
	public boolean checkin(Room r) {
		
		if (r != null && r.getGuest() == null) {
			r.setGuest(this);
			this.room = r;
			return true;
		}
		return false;
	}
	
	/**
	 * Removes the <code>Guest</code> from his/her room.
	 * @return true if successful and false if the guest doesn't have a room.
	 */
	
	public boolean checkout() {
		if (room ==  null) {
			return false;
		} else {
			room.setGuest(null);
			this.room = null;
			return true;
		}
	}
	
	// ------------------ Queries --------------------------

    /**
     * Returns the name of this <code>Guest</code>.
     * @return the name of this <code>Guest</code>;
     */
	
	public String getName() {
		return name;
	}
	
	/**
     * Returns the current room the <code>Guest</code>.is living in.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not currently housed.
     */
	
	public Room getRoom() {
		return room;
	}
	
	/**
	 * Returns a description of the <code>Guest</code> and his/her <code>Room</code>.
	 */
	
	public String toString() {
		String output = name + " lives in room " + room.getNumber();
		return output;
	}
}
