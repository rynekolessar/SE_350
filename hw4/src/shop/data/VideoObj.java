package shop.data;

/**
 * Immutable Data Class for video objects. Comprises a triple: title, year,
 * director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant Title is non-null, no leading or final spaces, not empty
 *                  string.
 * @objectinvariant Year is greater than 1800, less than 5000.
 * @objectinvariant Director is non-null, no leading or final spaces, not empty
 *                  string.
 */
public final class VideoObj implements Comparable {
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _title;
	/** @invariant greater than 1800, less than 5000 */
	private final int _year;
	/** @invariant non-null, no leading or final spaces, not empty string */
	private final String _director;

	/**
	 * Initialize all object attributes. Title and director are "trimmed" to remove
	 * leading and final space.
	 * 
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {
		if (title == null) {
			throw new IllegalArgumentException();
		}

		if (director == null) {
			throw new IllegalArgumentException();
		}

		title = title.trim();
		director = director.trim();

		if (title.length() == 0 || title.startsWith(" ") || title.endsWith(" ")) {
			throw new IllegalArgumentException();
		}

		if (director.length() == 0 || director.startsWith(" ") || director.endsWith(" ")) {
			throw new IllegalArgumentException();
		}

		if (year <= 1800 || year >= 5000) {
			throw new IllegalArgumentException();
		}

		_title = title;
		_year = year;
		_director = director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		return _director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		return _title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		return _year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * 
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	public boolean equals(Object thatObject) {
		if (thatObject instanceof VideoObj) {
			VideoObj other = (VideoObj) thatObject;
			return (this._director.equals(other.director()) && this._title.equals(other.title())
					&& this._year == other.year());
		}
		return false;
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	public int hashCode() {
		int result = 17;
		int prime = 37;
		result = prime * result + _title.hashCode();
		result = prime * result + _year;
		result = prime * result + _director.hashCode();
		return result;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in the
	 * following order: title, year, director.
	 * 
	 * @param thatObject the Object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater thatObject.
	 * @throws ClassCastException if thatObject has an incompatible type.
	 */
	public int compareTo(Object thatObject) {
		VideoObj other = (VideoObj) thatObject;

		if (this._title.compareTo(other._title) != 0) {
			return this._title.compareTo(other._title);
		} else {
			if (this._year != other._year) {
				return this._year - other._year;
			} else {
				return this._director.compareTo(other._director);
			}
		}
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	public String toString() {
		return _title + " (" + _year + ") : " + _director;
	}
}