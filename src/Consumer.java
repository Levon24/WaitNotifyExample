/*
 * User: levon
 * Date: 20.03.2023
 * Time: 11:37
 */

/**
 * Consume something to do some work
 */
class Consumer implements Runnable {
  private final Transfer transfer;

  public Consumer(Transfer transfer) {
    this.transfer = transfer;
  }
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      transfer.receive();

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("InterruptedException: " + e.getMessage());
      }
    }
  }
}
