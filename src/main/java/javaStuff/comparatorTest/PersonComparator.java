package javaStuff.comparatorTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * write comparator to sort persons with name and then score
 */
public class PersonComparator {
  public static void main(String[] args) {
     List<Person> persons = PersonFactory.persons;
     persons.forEach(System.out::println);
    System.out.println("----------");

     persons.sort(new Comparator<Person>() {
       @Override
       public int compare(Person o1, Person o2) {
         if (o1.score == o2.score) {
           return o1.name.compareTo(o2.name);
         } else {
           return o1.score - o2.score;
         }
       }
     });
     persons.forEach(System.out::println);
  }
}

class Person {
  int score;
  String name;

  public Person(int score, String name) {
    this.score = score;
    this.name = name;
  }

  @Override
  public String toString() {
    return name + ": " + score;
  }
}


class PersonFactory {
  static List<Person> persons = new ArrayList<>();
  static {
    persons.addAll(Arrays.asList(new Person(25,"aaa"),
            new Person(24, "aaa"),
            new Person(24, "bbb"),
            new Person(23, "ccc"),
            new Person(23, "ddd"),
            new Person(26, "aaa"),
            new Person(26, "bbb")


    ));
  }
}