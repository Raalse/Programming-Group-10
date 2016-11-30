package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.*;

import static org.junit.Assert.*;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;
    private String pass = "password";

    @Before
    public void setUp() {
    	safe = new Safe(pass);
        guest = new Guest("Jip");
        room = new Room(101, safe);
        guest.checkin(room);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
        assertEquals(false, room.getSafe().isActive());
        assertEquals(false, room.getSafe().isOpen());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testGetSafe() {
    	assertTrue(room.getSafe().getPassword().testWord("password"));
    	assertFalse(room.getSafe().getPassword().testWord("pass"));
    }
    
    @Test
    public void testActivate() {
    	room.getSafe().activate("pass");
    	assertEquals(false, room.getSafe().isActive());
    	room.getSafe().activate("password");
    	assertEquals(true, room.getSafe().isActive());
    	room.getSafe().deactivate();
    	assertEquals(false, room.getSafe().isActive());
    }
    
    @Test
    public void testOpen() {
    	room.getSafe().open("pass");
    	assertEquals(false, room.getSafe().isOpen());
    	room.getSafe().activate("password");
    	room.getSafe().open("password");
    	assertEquals(true, room.getSafe().isOpen());
    	room.getSafe().close();
    	assertEquals(false, room.getSafe().isOpen());
    	room.getSafe().deactivate();
    }
    
    @Test
    public void testGetGuest() {
    	assertEquals("Jip", room.getGuest().getName());
    	assertNotEquals("Jop", room.getGuest().getName());
    }
}