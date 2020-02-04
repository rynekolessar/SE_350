package shop.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.command.Command;
import shop.data.Record;
import shop.data.VideoObj;
import shop.data.InventorySet;
import java.util.Iterator;

// TODO:
// write an integration test that tests the data classes.
// add in some videos, check out, check in, delete videos, etc.
// check that errors are reported when necessary.
// check that things are going as expected.
public class TEST1 {
  private InventorySet _inventory = Record.newInventory();
  private void expect(VideoObj v, String s) {
    Assertions.assertEquals(s,_inventory.get(v).toString());
  }
  private void expect(Record r, String s) {
    Assertions.assertEquals(s,r.toString());
  }

  @Test
  public void test1() {
    Command clearCmd = Record.newClearCmd(_inventory);
    clearCmd.run();
    
    VideoObj v1 = Record.newVideo("Title1", 2000, "Director1");
    Assertions.assertEquals(0, _inventory.size());
    Assertions.assertTrue(Record.newAddCmd(_inventory, v1, 5).run());
    Assertions.assertEquals(1, _inventory.size());
    Assertions.assertTrue(Record.newAddCmd(_inventory, v1, 5).run());
    Assertions.assertEquals(1, _inventory.size());
    // System.out.println(_inventory.get(v1));
    expect(v1,"Title1 (2000) : Director1 [10,0,0]");
    
    VideoObj v2 = Record.newVideo("Title2", 2001, "Director2");
    Assertions.assertTrue(Record.newAddCmd(_inventory, v2, 1).run());
    Assertions.assertEquals(2, _inventory.size());
    expect(v2,"Title2 (2001) : Director2 [1,0,0]");
    
    Assertions.assertFalse(Record.newAddCmd(_inventory, null, 5).run());
    Assertions.assertEquals(2, _inventory.size());
    
    Assertions.assertTrue(Record.newOutCmd(_inventory, v2).run());
    expect(v2,"Title2 (2001) : Director2 [1,1,1]");
    
    Assertions.assertTrue(Record.newInCmd(_inventory, v2).run());
    expect(v2,"Title2 (2001) : Director2 [1,0,1]");
    
    Assertions.assertTrue(Record.newAddCmd(_inventory, v2, -1).run());
    Assertions.assertEquals(1, _inventory.size());
    expect(v1,"Title1 (2000) : Director1 [10,0,0]");
    
    Command outCmd = Record.newOutCmd(_inventory, v1);
    Assertions.assertTrue(outCmd.run());
    Assertions.assertTrue(outCmd.run());
    Assertions.assertTrue(outCmd.run());
    Assertions.assertTrue(outCmd.run());
    expect(v1,"Title1 (2000) : Director1 [10,4,4]");
    
    Assertions.assertTrue(Record.newInCmd(_inventory, v1).run());
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");
    
    Assertions.assertTrue(Record.newAddCmd(_inventory, v2, 5).run());
    Assertions.assertEquals(2, _inventory.size());
    expect(v2,"Title2 (2001) : Director2 [5,0,0]");
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");

    Iterator<Record> it = _inventory.iterator(new java.util.Comparator<Record>() {
        public int compare (Record r1, Record r2) {
          return r2.numRentals() - r1.numRentals();
        }
      });
    expect(it.next(),"Title1 (2000) : Director1 [10,3,4]");
    expect(it.next(),"Title2 (2001) : Director2 [5,0,0]");
    Assertions.assertFalse(it.hasNext());
  }
}
