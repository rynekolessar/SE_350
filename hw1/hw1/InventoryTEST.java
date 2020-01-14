package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 * Tests the InventorySet Class.
 * 
 * @author Ryne Kolessar
 *
 */
public class InventoryTEST {
	public InventoryTEST(String name) {
		super();
	}

	InventorySet inventory = new InventorySet();

	final VideoObj video1 = new VideoObj("title1", 2020, "director1");
	final VideoObj video2 = new VideoObj("title2", 2019, "director2");

	/**
	 * Tests the size() method.
	 */
	@Test
	public void testSize() {
		Assertions.assertEquals(0, inventory.size());

		inventory.addNumOwned(video1, 1);
		Assertions.assertEquals(1, inventory.size());

		inventory.addNumOwned(video1, 2);
		Assertions.assertEquals(1, inventory.size());

		inventory.addNumOwned(video2, 1);
		Assertions.assertEquals(2, inventory.size());

		inventory.addNumOwned(video2, -1);
		Assertions.assertEquals(1, inventory.size());

		inventory.addNumOwned(video1, -3);
		Assertions.assertEquals(0, inventory.size());

		try {
			inventory.addNumOwned(video1, -3);
		} catch (IllegalArgumentException e) {
		}

		Assertions.assertEquals(0, inventory.size());
	}

	/**
	 * Tests the addNumOwned() method.
	 */
	@Test
	public void testAddNumOwned() {
		// TODO
		Assertions.assertEquals(0, inventory.size());

		inventory.addNumOwned(video1, 1);
		Assertions.assertEquals(video1, inventory.get(video1).video);

		Assertions.assertEquals(1, inventory.get(video1).numOwned);

		try {
			inventory.addNumOwned(video1, -2);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			inventory.addNumOwned(video1, 0);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		inventory.addNumOwned(video2, 10);
		inventory.checkOut(video2);
		inventory.checkOut(video2);

		try {
			inventory.addNumOwned(video2, -10);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

	}

	/**
	 * Tests the checkOut() and checkIn() methods.
	 */
	public void testCheckOutCheckIn() {
		inventory.addNumOwned(video1, 5);
		inventory.checkOut(video1);
		inventory.checkOut(video1);
		Assertions.assertEquals(2, inventory.get(video1).numOut);
		Assertions.assertEquals(5, inventory.get(video1).numOwned);

		inventory.checkIn(video1);
		Assertions.assertEquals(1, inventory.get(video1).numOut);
		Assertions.assertEquals(5, inventory.get(video1).numOwned);

		try {
			inventory.checkOut(video2);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			inventory.checkOut(video2);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Tests the clear() method.
	 */
	public void testClear() {
		inventory.addNumOwned(video1, 10);
		inventory.addNumOwned(video2, 22);
		inventory.addNumOwned(video1, 5);
		Assertions.assertEquals(2, inventory.size());
		inventory.clear();

		Assertions.assertEquals(0, inventory.size());
		Assertions.assertEquals(null, inventory.get(video1));
		Assertions.assertEquals(null, inventory.get(video2));
	}

	/**
	 * Tests the get() method.
	 */
	public void testGet() {
		inventory.addNumOwned(video1, 10);
		Record records = inventory.get(video1);
		Assertions.assertEquals(10, records.numOwned);
		Assertions.assertEquals(0, records.numOut);
		Assertions.assertEquals(0, records.numRentals);
		Assertions.assertFalse(records == inventory.get(video1));
	}

	/**
	 * Tests the toCollection() method.
	 */
	@Test
	public void testToCollection() {
		inventory.addNumOwned(video1, 50);
		inventory.addNumOwned(video2, 50);

		Collection<Record> records1 = inventory.toCollection();
		Collection<Record> records2 = inventory.toCollection();

		Assertions.assertTrue(records1 != records2);

		Assertions.assertFalse(records1.contains(inventory.get(video1)));
		Assertions.assertFalse(records1.contains(inventory.get(video2)));

		for (Record record : records1) {
			Assertions.assertEquals(50, record.numOwned);
		}
	}
}
