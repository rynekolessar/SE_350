package hw5.command;

public interface CommandHistory {
    /**
     * Add command <code>undoable</code> and clear <code>redoable</code>.
     * @param cmd the command to be run.
     */
    public void add(Command cmd);

    /**
     * Pop command from <code>undoable</code>, undo it, then push it
     * onto <code>redoable</code>.
     */
    public boolean undo();

    /**
     * Pop command from <code>redoable</code>, redo it, then push it
     * onto <code>undoable</code>.
     */
    public boolean redo();
}
