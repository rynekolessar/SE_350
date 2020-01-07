package serialization;
import java.io.*;

public class Main2 {
  public static void main(String args[]) {
    try {
      Person person = new Person("Matt", 30);
      PersonEntry entry = new PersonEntry(person, 1);
      ObjectOutputStream os
        = new ObjectOutputStream (new FileOutputStream("out.dat"));
      os.writeObject(entry);
      ObjectInputStream is
        = new ObjectInputStream (new FileInputStream("out.dat"));
      Object o = is.readObject();
      PersonEntry entry2 = (PersonEntry) o;
      System.out.println("Entry restored from file is" + entry2.toString());
    } catch (Exception e) { e.printStackTrace(); }
  }
}

class PersonEntry implements Serializable {
  private Person person = null;
  private int personNumber = 0;
  
  public PersonEntry(Person person, int personNumber) {
    this.person = person;
    this.personNumber = personNumber;
  }
  public Person getPerson() {
    return person;
  }
  public int getPersonNumber() {
    return personNumber;
  }
  public String toString() {
    return person.toString() +  " Number " + new Integer(personNumber);
  }
}

class Person {
  private String name = "";
  private int age = 0;
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  public String toString() {
    return "Name: " + name + " Age: " + new Integer(age);
  }
}

