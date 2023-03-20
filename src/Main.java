/*
 * User: levon
 * Date: 20.03.2023
 * Time: 11:38
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Transfer transfer = new Transfer();

    Producer producer = new Producer(transfer);
    new Thread(producer).start();

    // Let's wait a some time before start consume some work
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("InterruptedException: " + e.getMessage());
    }

    Consumer consumer = new Consumer(transfer);
    new Thread(consumer).start();
  }
}