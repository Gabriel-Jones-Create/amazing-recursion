package maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import config.Configuration;

public class MazeBuilderTest {

	private MazeBuilder builder;

	private String exitDesc = "This room is hung with hundreds of "
			+ "dusty tapestries. All show signs of wear: moth "
			+ "holes, scorch marks, dark stains, and the damage "
			+ "of years of neglect. They hang on all the walls "
			+ "and hang from the ceiling to brush against the floor, "
			+ "blocking your view of the rest of the room.";

	private String basicDesc = "You open the door, and the reek "
			+ "of garbage assaults your nose. Looking inside, "
			+ "you see a pile of refuse and offal that nearly "
			+ "reaches the ceiling. In the ceiling above it is "
			+ "a small hole that is roughly as wide as two human "
			+ "hands. No doubt some city dweller high above disposes "
			+ "of his rubbish without ever thinking about where it goes.";

	@Before
	public void setup() {
		builder = Configuration.getMazeBuilder();
		if (builder == null)
			fail("You seem to have forgotten to set which builder to use in the Configuraiton.getMazeBuilder method.");
		if (builder == Configuration.getMazeBuilder())
			fail("You should return a new instance of MazeBuilder when Configuration.getMazeBuilder() is called.");
	}

	@Test(timeout = 50)
	public void testCreateRoom() {
		Room room = builder.createRoom(basicDesc, "A smelly room.");
		assertFalse(room.isExit());
		assertEquals(basicDesc, room.getFullDescription());
		assertEquals("A smelly room.", room.getShortDescription());
		assertTrue(room.getRooms().isEmpty());
		assertEquals(0, room.getRooms().size());
	}

	@Test(timeout = 50)
	public void testCreateExit() {
		Room room = builder.createExit(exitDesc, "A dusty room.");
		assertTrue(room.isExit());
		assertEquals(exitDesc, room.getFullDescription());
		assertEquals("A dusty room.", room.getShortDescription());
		assertTrue(room.getRooms().isEmpty());
		assertEquals(0, room.getRooms().size());
	}

	@Test(timeout = 50)
	public void testAddPassage() {
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		Room r1 = builder.createRoom(exitDesc, "A dusty room.");
		builder.addPassage(r0, r1);
		assertFalse(r0.getRooms().isEmpty());
		assertFalse(r1.getRooms().isEmpty());
		
		assertEquals(1, r0.getRooms().size());
		assertEquals(1, r1.getRooms().size());
		
		assertEquals(0, r0.getRooms().contains(r1));
		assertEquals(0, r1.getRooms().contains(r0));
		
		builder.addPassage(r0, r1);
		assertFalse(r0.getRooms().isEmpty());
		assertFalse(r1.getRooms().isEmpty());
		
		assertEquals(1, r0.getRooms().size());
		assertEquals(1, r1.getRooms().size());
		
		assertEquals(0, r0.getRooms().contains(r1));
		assertEquals(0, r1.getRooms().contains(r0));
	}
	
	@Test(timeout = 50)
	public void testBuildCircularRooms() {
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		Room r1 = builder.createRoom(exitDesc, "A dusty room.");
		Room r2 = builder.createRoom("Another room", "meh.");
		Room r3 = builder.createRoom("Fourth room", "more.");
		builder.addPassage(r0, r1);
		builder.addPassage(r1, r2);
		builder.addPassage(r2, r3);
		builder.addPassage(r3, r0);
		assertEquals(2, r0.getRooms().size());
		assertEquals(2, r1.getRooms().size());
		assertEquals(2, r2.getRooms().size());
		assertEquals(2, r3.getRooms().size());
		
		assertNotEquals(-1, r0.getRooms().contains(r1));
		assertNotEquals(-1, r0.getRooms().contains(r3));
		
		assertNotEquals(-1, r1.getRooms().contains(r0));
		assertNotEquals(-1, r1.getRooms().contains(r2));
		
		assertNotEquals(-1, r2.getRooms().contains(r1));
		assertNotEquals(-1, r2.getRooms().contains(r3));
		
		assertNotEquals(-1, r3.getRooms().contains(r0));
		assertNotEquals(-1, r3.getRooms().contains(r2));
	}
	
	@Test(timeout = 50)
	public void testAddOneWayPassage() {
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		Room r1 = builder.createRoom(exitDesc, "A dusty room.");
		builder.addOneWayPassage(r0, r1);
		assertFalse(r0.getRooms().isEmpty());
		assertTrue(r1.getRooms().isEmpty());
		
		assertEquals(1, r0.getRooms().size());
		assertEquals(0, r1.getRooms().size());
		
		assertEquals(0, r0.getRooms().contains(r1));
		assertEquals(-1, r1.getRooms().contains(r0));
		
		builder.addOneWayPassage(r0, r1);
		assertFalse(r0.getRooms().isEmpty());
		assertTrue(r1.getRooms().isEmpty());
		
		assertEquals(1, r0.getRooms().size());
		assertEquals(0, r1.getRooms().size());
		
		assertEquals(0, r0.getRooms().contains(r1));
		assertEquals(-1, r1.getRooms().contains(r0));
	}
	@Test (timeout = 500)
	public void testAddingLotsOfRooms() {
		Room r0 = builder.createRoom("An orange room!", "Orange Hallway");
		Room r1 = builder.createRoom("A red room!", "Red Hallway");
		Room r2 = builder.createRoom("A blue room!", "Blue Hallway.");
		Room r3 = builder.createRoom("A purple room!", "Purple Hallway.");
		Room r4 = builder.createRoom("An green room!", "Green Hallway");
		Room r5 = builder.createRoom("A Brown room!", "Brown Hallway");
		Room r6 = builder.createRoom("A Black room!", "Black Hallway.");
		Room r7 = builder.createRoom("A Beige room!", "Beige Hallway.");
		Room r8 = builder.createRoom("An Turqoise room!", "Turcoise Hallway");
		Room r9 = builder.createRoom("A Yard room!", "Yard Hallway");
		Room r10 = builder.createRoom("A Light room!", "Light Hallway.");
		Room r11 = builder.createRoom("A Haber room!", "Haber Hallway.");
		Room r12 = builder.createRoom("An Paper room!", "paper Hallway");
		Room r13 = builder.createRoom("A Wood room!", "Wood Hallway");
		Room r15 = builder.createExit("A Hood room!", "Hood Hallway");
		builder.addPassage(r0, r1).addPassage(r0, r2).addPassage(r0, r3).addPassage(r1, r4).addPassage(r1, r5)
		.addPassage(r2, r6).addPassage(r2, r7).addPassage(r3, r8).addPassage(r3, r9).addPassage(r6, r8)
		.addPassage(r9, r3).addPassage(r12, r6).addPassage(r10, r15).addPassage(r11, r13).addPassage(r15, r5);
		assertFalse(r0.getRooms().isEmpty());
		assertFalse(r1.getRooms().isEmpty());
		assertEquals(-1, r2.getRooms().contains(r3));
		assertEquals(-1, r4.getRooms().contains(r5));
		assertFalse(r6.getRooms().isEmpty());
		assertFalse(r7.getRooms().isEmpty());
		assertEquals(-1, r10.getRooms().contains(r11));
		assertEquals(-1, r12.getRooms().contains(r13));
		assertFalse(r15.getRooms().isEmpty());
		assertFalse(r8.getRooms().isEmpty());
		assertEquals(-1, r2.getRooms().contains(r4));
		assertEquals(-1, r3.getRooms().contains(r15));
		assertFalse(r9.getRooms().isEmpty());
		assertFalse(r10.getRooms().isEmpty());
		assertEquals(-1, r12.getRooms().contains(r13));
		assertEquals(-1, r1.getRooms().contains(r12));
		assertFalse(r2.getRooms().isEmpty());
		assertFalse(r15.getRooms().isEmpty());
		assertEquals(-1, r10.getRooms().contains(r2));
		assertEquals(-1, r9.getRooms().contains(r5));
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE1(){
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		builder.addPassage(null, r0);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE2(){
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		builder.addPassage(r0, null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE3(){
		builder.addPassage(null, null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE4(){
		builder.createRoom(null, null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE5(){
		builder.createRoom("Something", null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE6(){
		builder.createRoom(null, "Something");
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE7(){
		builder.createExit(null, null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE8(){
		builder.createRoom("Something", null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE9(){
		builder.createRoom(null, "Something");
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE10(){
		builder.addOneWayPassage(null, null);
	}
	
	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE11(){
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		builder.addOneWayPassage(r0, null);
	}

	@Test (timeout = 50, expected = NullPointerException.class)
	public void testNPE12(){
		Room r0 = builder.createRoom(basicDesc, "A smelly room.");
		builder.addOneWayPassage(null, r0);
	}
	
}

