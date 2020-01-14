package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the VideoObj Class.
 * 
 * @author Ryne Kolessar
 *
 */
public class VideoTEST {
	public VideoTEST(String name) {
		super();
	}

	/**
	 * Tests the constructor and Attributes.
	 */
	@Test
	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		Assertions.assertSame(title1, v1.title());
		Assertions.assertEquals(year, v1.year());
		Assertions.assertSame(director1, v1.director());

		VideoObj v2 = new VideoObj(title2, year, director2);
		Assertions.assertEquals(title1, v2.title());
		Assertions.assertEquals(director1, v2.director());
	}

	/**
	 * Tests the constructor to make sure the year falls between 1800-5000.
	 */
	@Test
	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj("X", 5000, "Y");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			Assertions.fail();
		}
	}

	/**
	 * Tests the Constructor to make sure a title exists.
	 */
	@Test
	public void testConstructorExceptionTitle() {
		try {
			new VideoObj(null, 2002, "Y");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj("", 2002, "Y");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj(" ", 2002, "Y");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Tests the Constructor to make sure a director exists.
	 */
	@Test
	public void testConstructorExceptionDirector() {
		try {
			new VideoObj("title", 2002, null);
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj("title", 2002, "");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			new VideoObj("title", 2002, " ");
			Assertions.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Tests the hashCode() function.
	 */
	@Test
	public void testHashCode() {
		Assertions.assertEquals(-875826552, new VideoObj("None", 2009, "Zebra").hashCode());
		Assertions.assertEquals(-1391078111, new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	/**
	 * Tests the equals() method.
	 */
	@Test
	public void testEquals() {
		VideoObj v1 = new VideoObj("title", 2020, "director");
		VideoObj v2 = new VideoObj("title", 2020, "director");
		Assertions.assertTrue(v1.equals(v2));
		v2 = new VideoObj("no", 2019, "no");
		Assertions.assertFalse(v1.equals(v2));
	}

	/**
	 * Tests the compareTo() method.
	 */
	@Test
	public void testCompareTo() {
		VideoObj v1 = new VideoObj("title", 2020, "director");
		VideoObj v2 = new VideoObj("title", 2020, "director");
		Assertions.assertEquals(v1.compareTo(v2), 0);

		v2 = new VideoObj("title", 2021, "director");
		Assertions.assertTrue(v1.compareTo(v2) < 0);

		v2 = new VideoObj("title", 2019, "director");
		Assertions.assertTrue(v1.compareTo(v2) > 0);

		v2 = new VideoObj("titletitle", 2020, "directordirector");
		Assertions.assertTrue(v1.compareTo(v2) < 0);

		v2 = new VideoObj("title", 2019, "director");
		Assertions.assertTrue(v1.compareTo(v2) > 0);

		v2 = new VideoObj("a", 2020, "i");
		Assertions.assertTrue(v1.compareTo(v2) > 0);

		v2 = new VideoObj("title", 2020, "director");
		Assertions.assertTrue(v1.compareTo(v2) == 0);
	}

	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString() {
		VideoObj v1 = new VideoObj("Movie", 2020, "Ryne");
		Assertions.assertEquals(v1.toString(), "Movie (2020) : Ryne");
	}
}