package ss.week3.hotel;

public class Hotel {
	
	// ------------------ Instance variables ----------------
	
	public String name = "";
	private static final String INITIAL = "password";
	public PricedRoom room1 = new PricedRoom(1, 500, 43.50);
	public PricedRoom room2 = new PricedRoom(2, 700, 46.20);
	private Password pass;
	public Guest guest1 = new Guest("");
	public Guest guest2 = new Guest("");
	
	// ------------------ Constructor ------------------------

    /**
     * Creates a <code>Hotel</code> with the given name.
     * @param n name of the new <code>Hotel</code>
     */
	public Hotel(String n) {
		pass = new Password();
		name = n;
	}
	
	// ------------------ Commands --------------------------
	
	/**
	 * 
	 * @invariant getFreeRoom() == null || getFreeRoom() == room
	 * @invariant getRoom(n) == null || getRoom(n) == room
	 * @invariant getPassword() == null || getPassword() == pass
	 * @invariant getName() == name
	 * @private invariant name != null;
	 */
	
	
	/**
	 * Checks in a guest with the given <code>n</code> if the given <code>p</code> is correct,
	 * there is a free room and there are no guests with the same name already checked in.
	 * @param p password for checking in
	 * @param n name of new guest
	 * @return room of the new quest or null if checkIn failed
	 * @ensures checkIn(p, n) == null || checkIn(p ,n) == room
	 */	
	public PricedRoom checkIn(String p, String n) {
		assert p.equals(null) == false;
		assert n.equals(null) == false;
		if (p != INITIAL) {
			return null;
		}
		
		if (getFreeRoom() == null) {
			return null;
		}
		
		if (n.equals(guest1.getName()) || n.equals(guest2.getName())) {
			return null;
		}
		
		if (guest1.getName() == "") {
			guest1 = new Guest(n);
			guest1.checkin(room1);
			return room1;
		} else if (guest2.getName() == "") {
			guest2 = new Guest(n);
			guest2.checkin(room2);
			return room2;
		} else { 
			return null;
		}
	}
	
	/**
	 * Checks out someone with a given name.
	 * @param n name of the guest
	 */
	public void checkOut(String n) {
		assert n.equals(null) == false;
		if (n == guest1.getName()) {
			guest1.getRoom().getSafe().deactivate();
			guest1.checkout();
			guest1 = null;
		} else {
			if (n == guest2.getName()) {
				guest2.getRoom().getSafe().deactivate();
				guest2.checkout();
				guest2 = null;
			}
		}
	}
	
	// ------------------ Queries --------------------------
	
	/**
	 * Gives the first free room.
	 * @return free room or null if no free room available;
	 */	
	public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		} else { 
			if (room2.getGuest() == null) {
				return room2;
			} else {
				return null;
			}
		}
	}
	
	/**
	 * @param n name of the guest
	 * @return room for guest with given name;
	 */
	public Room getRoom(String n) {
		assert n.equals(null) == false;
		if (n == guest1.getName()) {
			return guest1.getRoom();
		} else {
			if (n == guest2.getName()) {
				return guest2.getRoom();
			} else {
				return null;
			}
		}	
	}
	
	/**
	 * @return password of the hotel;
	 */
	public Password getPassword() {
		return pass;
	}
	
	/**
	 * @return description of rooms in hotel;
	 */
	public String toString() {
		String output;
		String safe1 = " non-active";
		String safe2 = " non-active";
		if (guest1.getRoom() != null && guest1.getRoom().getSafe().isActive()) {
			safe1 = "n active";
		}
		if (guest2.getRoom() != null && guest2.getRoom().getSafe().isActive()) {
			safe2 = "n active";
		}
		output = "Room " + room1.getNumber() + " has a" + safe1 + " safe and houses " + guest1.getName() + ".";
		output += "\nRoom " + room2.getNumber() + " has a" + safe2 + " safe and houses " + guest2.getName() + ".";
		return output;
	}
	
	/**
	 * @return hotel name;
	 */
	public String getName() {
		return name;
	}
	
	public String getBill(String guestName, int nights, java.io.PrintStream theOutStream) {
		Guest guest;
		Bill bill = new Bill(theOutStream);
		if (guest1.getName().equals(guestName)) {
			guest = guest1;
		} else if (guest2.getClass().equals(guestName)) {
			guest = guest2;
		} else {
			return null;
		}
		for (int i = 1; i <= nights; i++) {
			bill.newItem(guest.getRoom());
		}
		if (guest.getRoom().getSafe().isActive()) {
			bill.newItem(guest.getRoom().getSafe());
		}
		
		//price = (guest.getRoom().getAmount() + guest.getRoom().getSafe().getAmount()) * nights;
		//price = guest.getRoom().getAmount() * nights + guest.getRoom().getSafe().getAmount();
		return null;
	}
}