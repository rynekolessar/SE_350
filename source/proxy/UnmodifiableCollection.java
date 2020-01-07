package proxy;
import java.util.Collection;
import java.util.Iterator;
import java.io.Serializable;

class UnmodifiableCollection implements Collection, Serializable {
  Collection c;
  
  UnmodifiableCollection(Collection c) {
    if (c==null)
      throw new NullPointerException();
    this.c = c;
  }
  
  public int      size()                    {return c.size();}
  public boolean  isEmpty()                 {return c.isEmpty();}
  public boolean  contains(Object o)        {return c.contains(o);}
  public Object[] toArray()                 {return c.toArray();}
  public Object[] toArray(Object[] a)       {return c.toArray(a);}
  public String   toString()                {return c.toString();}
  public boolean  containsAll(Collection d) {return c.containsAll(d);}
  
  public Iterator iterator() {
    return new Iterator() {
        Iterator i = UnmodifiableCollection.this.c.iterator();
        
        public boolean hasNext() {return i.hasNext();}
        public Object next()     {return i.next();}
        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  public boolean add(Object o){
    throw new UnsupportedOperationException();
  }
  public boolean remove(Object o) {
    throw new UnsupportedOperationException();
  }
  public boolean addAll(Collection coll) {
    throw new UnsupportedOperationException();
  }
  public boolean removeAll(Collection coll) {
    throw new UnsupportedOperationException();
  }
  public boolean retainAll(Collection coll) {
    throw new UnsupportedOperationException();
  }
  public void clear() {
    throw new UnsupportedOperationException();
  }
}
