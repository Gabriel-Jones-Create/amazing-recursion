package structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import config.Configuration;

public class ListInterfaceTest {

	private ListInterface<String> list;
	
	@Before
	public void setup(){
		list = Configuration.getListInterface();
		ListInterface<String> l2 = Configuration.getListInterface();
		if(list == null)
			fail("You didn't set your list in the Configuration file.");
		if(list == l2)
			fail("You should return a new instance of list with each call to Configuration.getListInterface()");
	}
	
	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}
	
	@Test (timeout = 500)
	public void testInsertLastIsEmptySizeAndGetLast() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert Last should return instance of self", list, list.insertLast("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("Last element should .equals \"hello\".", "hello", list.getLast());
		list.insertLast("world");
		assertEquals(2, list.size());
		list.insertLast("foo");
		assertEquals(3, list.size());
		assertEquals("Last element should .equals \"foo\".", "foo", list.getLast());
	}
	
	@Test (timeout = 500)
	public void testInsertAtIsEmptySizeAndGetAt() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert At should return instance of self", list, list.insertAt(0, "hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("0th element should .equals \"hello\".", "hello", list.get(0));
		list.insertAt(1, "world");
		assertEquals("1th element should .equalse \"world\".", "world", list.get(1));
		assertEquals(2, list.size());
		list.insertAt(0, "foo");
		assertEquals(3, list.size());
		assertEquals("0th element should .equals \"foo\".", "foo", list.get(0));
		assertEquals("1th element should .equals \"hello\".", "hello", list.get(1));
		assertEquals("2th element should .equals \"world\".", "world", list.get(2));
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyGetFirst() {
		list.getFirst();
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyGetLast() {
		list.getLast();
	}
	
	@Test (timeout = 500)
	public void testInsertFirstRemoveFirstSizeAndIsEmpty() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertFirst("hello").insertFirst("there").insertFirst("world");
		assertEquals("List should now have 3 elements", 3, list.size());
		assertEquals("world", list.removeFirst());
		assertEquals("List should now have 2 elements", 2, list.size());
		assertEquals("there", list.removeFirst());
		assertEquals("List should now have 1 elements", 1, list.size());
		assertEquals("hello", list.removeFirst());
		assertEquals("List should now have 0 elements", 0, list.size());
		assertTrue("All elements removed, list should be empty.", list.isEmpty());
	}
	
	@Test (timeout = 500)
	public void testInsertLastRemoveLastSizeAndIsEmpty() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertLast("hello").insertLast("there").insertLast("world");
		assertEquals("List should now have 3 elements", 3, list.size());
		assertEquals("world", list.removeLast());
		assertEquals("List should now have 2 elements", 2, list.size());
		assertEquals("there", list.removeLast());
		assertEquals("List should now have 1 elements", 1, list.size());
		assertEquals("hello", list.removeLast());
		assertEquals("List should now have 0 elements", 0, list.size());
		assertTrue("All elements removed, list should be empty.", list.isEmpty());
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyRemoveFirst() {
		list.removeFirst();
	}
	
	@Test (timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyRemoveLast() {
		list.removeLast();
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testExceptionOnOutOfBounds1() {
		list.removeAt(0);
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testExceptionOnOutOfBounds2() {
		list.insertFirst("hello");
		list.removeAt(1);
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testExceptionOnOutOfBounds3() {
		list.removeAt(-5);
	}
	
	@Test (timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testExceptionOnOutOfBounds4() {
		list.insertFirst("hello");
		list.removeAt(5);
	}
	
	@Test (timeout = 500)
	public void testInsertsGetsRemovesSize(){
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertLast("Hello").insertLast("World!");
		assertEquals("Insert at should return an instance of the list.", list, list.insertAt(1, "There"));
		assertEquals("Size should be 3", 3, list.size());
		assertEquals("0th element should .equals \"Hello\"", "Hello", list.get(0));
		assertEquals("Last element should .equals \"World!\"", "World!", list.getLast());
		list.insertAt(0, "foo").insertAt(4, "bar");
		assertEquals("foo", list.get(0));
		assertEquals("bar", list.get(4));
		assertEquals("Size should be 5", 5, list.size());
		assertEquals("The third element should have been \"World!\"", "World!", list.removeAt(3));
		assertEquals("Size should be 4", 4, list.size());
		assertEquals("Last element should be \"bar\"", "bar", list.getLast());
	}
	
	@Test (timeout = 500)
	public void testInsertsRemoveAndContains(){
		list.insertLast("Hello").insertLast("World");
		assertEquals("Hello is at index 0", 0, list.contains("Hello"));
		assertEquals("World is at index 1", 1, list.contains("World"));
		assertEquals("Foo is not in the list.", -1, list.contains("Foo"));
		assertTrue("Hello can be removed.", list.remove("Hello"));
		assertEquals("Size should now be 1", 1, list.size());
		list.insertLast("Hello").insertLast("There").insertLast("Hello");
		assertEquals("World is at index 0", 0, list.contains("World"));
		assertEquals("First Hello is at index 1", 1, list.contains("Hello"));
		assertTrue("Hello can be removed.", list.remove("Hello"));
		assertEquals("First Hello is at index 2", 2, list.contains("Hello"));
		assertTrue("Hello can be removed.", list.remove("Hello"));
		assertEquals("Size of list should now be 2", 2, list.size());
		assertFalse("Foo cannot be removed.", list.remove("Foo"));
		assertEquals("Size of list should now be 2", 2, list.size());
		assertFalse("Hello cannot be removed.", list.remove("Hello"));
	}
	
	@Test (timeout = 1000)
	public void testSpeed() {
		for(int i = 0; i < 500000; i++){
			assertEquals(i, list.size());
			list.insertFirst("MORE!");
			list.getFirst();
		}
		
		while(!list.isEmpty())
			list.removeFirst();
	}
	
	

}
