package hw5.data;

public class RecordObj implements Record {
    Video video;
    int numOwned;
    int numOut;
    int numRentals;

    public RecordObj(Video video, int numOwned, int numOut, int numRentals) {
        this.video = video;
        this.numOwned = numOwned;
        this.numOut = numOut;
        this.numRentals = numRentals;
    }

    /**
     * @return the video.
     * <p><b>Invariant:</b> <code>video() != null</code>.</p>
     */
    public Video video() {
        return video;
    }

    /**
     * @return the number of copies of the video that are in the inventory.
     * <p><b>Invariant:</b> <code>numOwned() > 0</code>.</p>
     */
    public int numOwned() {
        return numOwned;
    }

    /**
     * @return the number of copies of the video that are currently checked out.
     * <p><b>Invariant:</b> <code>numOut() <= numOwned()</code>.</p>
     */
    public int numOut() {
        return numOut;
    }

    /**
     * @return the total number of times this video has ever been checked out.
     * <p><b>Invariant:</b> <code>numRentals() >= numOut()</code>.</p>
     */
    public int numRentals() {
        return numRentals;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(video);
        buffer.append(" [");
        buffer.append(numOwned);
        buffer.append(",");
        buffer.append(numOut);
        buffer.append(",");
        buffer.append(numRentals);
        buffer.append("]");
        return buffer.toString();
    }

}
