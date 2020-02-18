package hw5.data;

import hw5.command.Command;

public class CmdOut implements Command {
    private InventorySet _inventory;
    private Record _oldvalue;
    private Video _video;
    public CmdOut(InventorySet inventory, Video video) {
        this._inventory = inventory;
        this._video = video;
    }

    /**
     * The Command body.
     * @return true if command succeeds,false otherwise
     */
    public boolean run() {
        if(_oldvalue != null) {
            return false;
        }
        try {
            _oldvalue = _inventory.checkOut(_video);
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
        _inventory.replaceEntry(_video, _oldvalue);
    }

    /**
     * redo the command.
     */
    public void redo() {
        _inventory.checkOut(_video);
    }
}
