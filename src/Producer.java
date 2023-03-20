/*
 * User: levon
 * Date: 20.03.2023
 * Time: 11:35
 */

/**
 * Produce something to do some work
 */
class Producer implements Runnable {
  private final Transfer transfer;

  public Producer(Transfer transfer) {
    this.transfer = transfer;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      transfer.transfer();

      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        System.out.println("InterruptedException: " + e.getMessage());
      }
    }
  }
}

