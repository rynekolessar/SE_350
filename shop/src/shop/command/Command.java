package shop.command;
 /**
  * An UndoableCommand may be run at most once.
  */
public interface Command {
    /**
     * The Command body.
     * @return true if command succeeds,false otherwise
     */
    public boolean run();
}
