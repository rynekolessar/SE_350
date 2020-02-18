package shop.command;
import java.util.Stack;

public final class CommandHistoryObj implements CommandHistory {
    Stack<Command> undoStack = new Stack<Command>();
    Stack<Command> redoStack = new Stack<Command>();

    public void add(Command cmd) {
        undoStack.add(cmd);
        redoStack.clear();
    }

    public boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            redoStack.push(undoStack.pop()).undo();
        }
        return result;
    }

    public boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            undoStack.push(redoStack.pop()).redo();
        }
        return result;
    }

    // For testing
    Command topUndoCommand() {
        if (undoStack.empty()) {
            return null;
        } else {
            return undoStack.peek();
        }
    }

    // For Testing
    Command topRedoCommand () {
        if (redoStack.empty()) {
            return null;
        } else {
            return redoStack.peek();
        }
    }
}
