package serialization.custom;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class IntList2 implements IntList
{
  private LinkedList _v;
  private void setV(LinkedList v) { _v = _v; }

  public IntList2()               { _v = new LinkedList(); }
  public void addBack(int i)      { _v.addLast(new Integer(i)); }
  public void addFront(int i)     { _v.addFirst(new Integer(i)); }
  public int removeFront()        { return ((Integer)(_v.removeFirst())).intValue(); }
  public int removeBack()         { return ((Integer)(_v.removeLast())).intValue(); }
  public boolean isEmpty()        { return (_v.size() == 0); }

  public IntList copy() {
    IntList2 v = new IntList2();
    v.setV((LinkedList)(_v.clone()));
    return v;
  }

  private void writeObject(ObjectOutputStream out) throws IOException 
  { System.out.println("call specialized writer");
    out.writeInt(_v.size());
    for (Iterator i = _v.iterator(); i.hasNext(); )
      out.writeInt(((Integer) i.next()).intValue());
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
  { System.out.println("call specialized reader");
    _v = new LinkedList();
    int size = in.readInt();
    for (int i = 0;  i<size; i++)
      addBack(in.readInt());
  }
}

public class Main2 {
  public static void main(String[] args)
    throws IOException, FileNotFoundException, ClassNotFoundException 
  {
    IntList L = new IntList2();
    for (int i=0; i<1000; i++)
      L.addFront(i);
    
    ObjectOutputStream os = new ObjectOutputStream (new FileOutputStream("out2.dat"));
    os.writeObject(L);
    os.flush();

    ObjectInputStream in = new ObjectInputStream (new FileInputStream("out2.dat")); 
    IntList V = (IntList) in.readObject();
  }
}
