package enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


// Typesafe enum (From Bloch)
//
public final class Card {
  // Rank of Card
  private final Rank _rank;

  // Suit of Card
  private final Suit _suit;

  // Private constructor: All instances created in the class
  private Card(Rank rank, Suit suit) {
    _rank = rank;
    _suit = suit;
  }

  public String toString() {
    return _rank + " of " + _suit;
  }

  public int compareRank(Card c) {
    return _rank.compareTo(c._rank);
  }

  public int compareSuit(Card c) {
    return _suit.compareTo(c._suit);
  }

  public Rank getRank() {
    return _rank;
  }

  public int getRankValue() {
    return _rank.getValue();
  }

  public Suit getSuit() {
    return _suit;
  }

  public static final List MUTABLE_VALUES = new ArrayList(56);

  static {
    Iterator isuit = Suit.VALUES.iterator();

    while (isuit.hasNext()) {
      Suit s = (Suit) isuit.next();
      Iterator irank = Rank.VALUES.iterator();

      while (irank.hasNext()) {
        Rank r = (Rank) irank.next();
        MUTABLE_VALUES.add(new Card(r, s));
      }
    }
  }

  public static final List VALUES = Collections.unmodifiableList(MUTABLE_VALUES);
}
