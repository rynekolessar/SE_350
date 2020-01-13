package hw1;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  complete the tests
public class VideoTEST extends TestCase {
	@test
	public VideoTEST(String name) {
		super(name);
	}

	@test
	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		Assert.assertSame(title1, v1.title());
		Assert.assertEquals(year, v1.year());
		Assert.assertSame(director1, v1.director());

		VideoObj v2 = new VideoObj(title2, year, director2);
		Assert.assertEquals(title1, v2.title());
		Assert.assertEquals(director1, v2.director());
	}

	@test
	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 5000, "Y");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			Assert.fail();
		}
	}

	@test
	public void testConstructorExceptionTitle() {
		try {
			new VideoObj(null, 2002, "Y");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj("", 2002, "Y");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			new VideoObj(" ", 2002, "Y");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@test
	public void testConstructorExceptionDirector() {
		// TODO
	}

	@test
	public void testHashCode() {
		Assert.assertEquals(-875826552, new VideoObj("None", 2009, "Zebra").hashCode());
		Assert.assertEquals(-1391078111, new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	@test
	public void testEquals() {
		// TODO
	}

	@test
	public void testCompareTo() {
		// TODO
	}

	@test
	public void testToString() {
		// TODO
	}
}