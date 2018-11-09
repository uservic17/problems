package dataStructures.stacksNQueues.animalShelter;

import java.sql.Timestamp;
import java.util.ArrayDeque;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out"basis.
 * People must adopt eitherthe"oldest"(based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * You may use the built-in Linkedlist data structure.
 */
public class AnimalQueue {

  private ArrayDeque<Dog> dogArrayDeque;
  private ArrayDeque<Cat> catArrayDeque;
  private long counter = 0;


  void enque(Animal animal) {
//    animal.setTimeStamp(System.currentTimeMillis());
    animal.setTimeStamp(counter++);
    if (animal instanceof Dog) {
      if (dogArrayDeque == null) {
        dogArrayDeque = new ArrayDeque<>();
      }
      dogArrayDeque.addLast((Dog)animal);
    } else {
      if (catArrayDeque == null) {
        catArrayDeque = new ArrayDeque<>();
      }
      catArrayDeque.addLast((Cat) animal);
    }
  }

  Animal dequeAny() {
    if (catArrayDeque.isEmpty() && dogArrayDeque.isEmpty()) {
      throw new IllegalStateException("No animal left for adoption");
    }
    if (catArrayDeque.isEmpty()) {
      return dogArrayDeque.poll();
    }
    if (dogArrayDeque.isEmpty()) {
      return catArrayDeque.poll();
    }
    return returnOlderAnimal();
  }

  private Animal returnOlderAnimal() {
    long catTimeStamp = catArrayDeque.peek().getTimeStamp();
    long dogTimeStamp = dogArrayDeque.peek().getTimeStamp();
    return catTimeStamp < dogTimeStamp ? catArrayDeque.poll() : dogArrayDeque.poll();
  }

  Dog dequeDog() {
    return dogArrayDeque.poll();
  }

  Cat dequeCat() {
    return catArrayDeque.poll();
  }


  @Override
  public String toString() {
    return "AnimalQueue" +
            "\nDogs=" + dogArrayDeque +
            "\nCats=" + catArrayDeque +
            '}';
  }
}

abstract class Animal {
  private long timeStamp;

  long getTimeStamp() {
    return timeStamp;
  }

  void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;

  }
}

class Dog extends Animal {

  @Override
  public String toString() {
    return "Dog " + getTimeStamp();
  }
}

class Cat extends Animal {
  @Override
  public String toString() {
    return "Cat " + getTimeStamp();
  }
}