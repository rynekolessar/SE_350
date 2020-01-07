package util;

import java.util.WeakHashMap;

public class WeakHashMap3 {
  WeakHashMap contents = new WeakHashMap ();
  
  public void put (Object key1, Object key2, Object key3, Object val) {
    getMap (getMap (this.contents, key1), key2).put (key3, val);
  }
  
  public Object get (Object key1, Object key2, Object key3) {
    return getMap (getMap (this.contents, key1), key2).get (key3);
  }
  
  WeakHashMap getMap (WeakHashMap map, Object key) {
    WeakHashMap result = (WeakHashMap)(map.get (key));
    if (result == null) {
      result = new WeakHashMap ();
      map.put (key, result);
    }
    return result;
  }
  
}
