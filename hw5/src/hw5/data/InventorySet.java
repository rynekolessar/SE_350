package hw5.data;

import hw5.command.CommandHistory;
import hw5.command.CommandHistoryObj;

import java.util.*;

public class InventorySet implements Inventory {
    private Map<Video,Record> _data;
    private final CommandHistoryObj _history;
    InventorySet() {
        this._data = new HashMap<Video,Record>();
        this._history = new CommandHistoryObj();
    }

    public int size() {
        return _data.size();
    }

    public Record get(Video v) {
        return _data.get(v);
    }

    public Iterator<Record> iterator() {
        return Collections.unmodifiableCollection(_data.values()).iterator();
    }

    public Iterator<Record> iterator(Comparator<Record> comparator) {
        List<Record> l = new ArrayList<>(_data.values());
        l.sort(comparator);
        return l.iterator();
    }

    public boolean undo() {
        // TODO
        return false;
    }

    public boolean redo() {
        // TODO
        return false;
    }

    public Record addNumOwned(Video video, int change) {
        if (video == null || change == 0)
            throw new IllegalArgumentException();

        RecordObj r = (RecordObj) _data.get(video);
        if (r == null && change < 1) {
            throw new IllegalArgumentException();
        } else if (r == null) {
            _data.put(video, new RecordObj(video, change, 0, 0));
        } else if (r.numOwned+change < r.numOut) {
            throw new IllegalArgumentException();
        } else if (r.numOwned+change < 1) {
            _data.remove(video);
        } else {
            _data.put(video, new RecordObj(video, r.numOwned + change, r.numOut, r.numRentals));
        }
        return r;
    }

    public CommandHistory getHistory() {
        return _history;
    }

    public void replaceEntry(Video video, Record record) {
        _data.remove(video);
        if (record != null) {
            _data.put(video, record);
        }
    }

    public Map clear() {
        HashMap<Video,Record> h = new HashMap<Video,Record>(_data);
        _data.clear();
        return h;
    }

    public void replaceMap(Map<Video,Record> data) {
        _data = data;
    }

    public Record checkIn(Video video) {
        RecordObj r1 = (RecordObj)_data.get(video);
        if(r1 == null || r1.numOut < 1) {
            throw new IllegalArgumentException();
        }
        _data.put(video,new RecordObj(video, r1.numOwned, r1.numOut - 1, r1.numRentals));
        return r1;
    }

    public Record checkOut(Video video) {
        RecordObj r1 = (RecordObj)_data.get(video);
        if(r1 == null || r1.numOut == r1.numOwned) {
            throw new IllegalArgumentException();
        }
        _data.put(video,new RecordObj(video, r1.numOwned, r1.numOut + 1, r1.numRentals));
        return r1;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Database:\n");
        Iterator i = _data.values().iterator();
        while (i.hasNext()) {
            buffer.append("  ");
            buffer.append(i.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
