package simplebdd.bool;

public interface BoolPredFunctions {
  public String toGraphString (BoolPred p);
}

class BPFunctions implements BoolPredFunctions {
  /** @throws ClassCastException if p is not created by BoolPred.factory() */
  public String toGraphString (BoolPred p) {
    ((pBoolPred)p).initToGraphString();
    StringBuffer b = new StringBuffer();
    ((pBoolPred)p).toGraphString(b);
    return b.toString();
  }
}
