import java.util.concurrent.atomic.AtomicInteger;

public class CounterThreads {

  public static void main(String[] args) throws InterruptedException {
    // Use AtomicInteger for thread-safe flag
    AtomicInteger threadOneFinished = new AtomicInteger(0);

    // Thread 1 - Counting Up
    Thread thread1 = new Thread(() -> {
      System.out.println("\nThread 1 Counting Up");
      System.out.println("--------------------");
      for (int i = 0; i <= 20; i++) {
        System.out.println(i);
        try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      threadOneFinished.set(1);  // Set to 1 after finishing
    });

    // Thread 2 - Counting Down (waits on flag)
    Thread thread2 = new Thread(() -> {
      while (threadOneFinished.get() == 0) {
        // Wait for thread 1 to finish (value becomes 1)
      }
      System.out.println("\nThread 2 Counting Down");
      System.out.println("--------------------");
      for (int i = 20; i >= 0; i--) {
        System.out.println(i);
        try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    });

    // Start Thread 1
    thread1.start();

    // Start Thread 2 after Thread 1 finishes
    thread2.start();

    // Wait for both threads to finish
    thread1.join();
    thread2.join();
  }
}
