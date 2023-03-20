/*
 * User: levon
 * Date: 20.03.2023
 * Time: 11:34
 */

/**
 * This class needs for transfer some work from producer to consumer.
 * For simplify we just have a counter of some work.
 */
public class Transfer {
  private int counter;

  /**
   * Received nothing to do something
   */
  public synchronized void receive() {
    // If counter 0 no need to do something
    while (counter <= 0) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        System.out.println("InterruptedException: " + e.getMessage());
      }
    }

    counter--;

    System.out.println("Decremented counter");
    System.out.println("Current counter: " + counter);

    notify();
  }

  /**
   * Transfer nothing to do something
   */
  public synchronized void transfer() {
    while (counter >= 4) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        System.out.println("InterruptedException: " + e.getMessage());
      }
    }

    counter++;

    System.out.println("Increment counter");
    System.out.println("Current counter: " + counter);

    notify();
  }
}
