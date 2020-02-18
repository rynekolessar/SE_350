package hw5.data;

import hw5.command.Command;
import java.util.Map;

/**
 * Implementation of command to clear the inventory.
 * @see Data
 */
final class CmdClear implements Command {
    private InventorySet _inventory;
    private Map _oldvalue;

    public CmdClear(InventorySet inventory) {
        this._inventory = inventory;
    }

    /**
     * The Command body.
     * @return true if command succeeds,false otherwise
     */
    public boolean run() {
        if (_oldvalue != null) {
            return false;
        }
        try {
            _oldvalue = _inventory.clear();
            _inventory.getHistory().add(this);
            return true;
        } catch (IllegalArgumentException | ClassCastException e) {
            return false;
        }
    }

    /**
     * undo the command.
     */
    public void undo() {
        _inventory.replaceMap(_oldvalue);
    }

    /**
     * redo the command.
     */
    public void redo() {
        _inventory.clear();
    }
}
