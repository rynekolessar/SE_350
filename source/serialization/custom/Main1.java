package serialization.custom;
import java.util.LinkedList;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class IntList1 implements IntList
{
  private LinkedList _v;
  private void setV(LinkedList v) { _v = _v; }

  public IntList1()               { _v = new LinkedList(); }
  public void addBack(int i)      { _v.addLast(new Integer(i)); }
  public void addFront(int i)     { _v.addFirst(new Integer(i)); }
  public int removeFront()        { return ((Integer)(_v.removeFirst())).intValue(); }
  public int removeBack()         { return ((Integer)(_v.removeLast())).intValue(); }
  public boolean isEmpty()        { return (_v.size() == 0); }

  public IntList copy() {
    IntList1 v = new IntList1();
    v.setV((LinkedList)(_v.clone()));
    return v;
  }
}

public class Main1 {
  public static void main(String[] args)
    throws IOException, FileNotFoundException, ClassNotFoundException 
  {
    IntList L = new IntList1();
    for (int i=0; i<1000; i++)
      L.addFront(i);
    
    ObjectOutputStream os = new ObjectOutputStream (new FileOutputStream("out1.dat"));
    os.writeObject(L);
    os.flush();

    ObjectInputStream in = new ObjectInputStream (new FileInputStream("out1.dat")); 
    IntList V = (IntList) in.readObject();
  }
}
