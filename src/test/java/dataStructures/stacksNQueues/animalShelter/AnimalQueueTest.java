package dataStructures.stacksNQueues.animalShelter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalQueueTest {

  @Test
  public void enque() throws InterruptedException {
    AnimalQueue queue = new AnimalQueue();
    queue.enque(new Cat());
    queue.enque(new Dog());
    queue.enque(new Dog());
    queue.enque(new Cat());
    System.out.println(queue);
    System.out.println(queue.dequeAny());
    System.out.println(queue);
    System.out.println(queue.dequeAny());
    System.out.println(queue);

  }

  @Test
  public void dequeAny() {
  }

  @Test
  public void dequeDog() {
  }

  @Test
  public void dequeCat() {
  }
}