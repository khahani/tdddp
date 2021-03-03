package designpattern.command.remote;

public class GarageDoor {
  private static final int OPEN = 1;
  private static final int CLOSE = 0;
  private int status = CLOSE;

  public void open() {
    if (!isOpen()) {
      try {
        System.out.println("Garage door is opening...");
        Thread.sleep(2000);
        status = OPEN;
        System.out.println("Garage door is opened");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Garage door is open.");
    }
  }

  private boolean isOpen() {
    return status == OPEN;
  }

  public void close() {
    if (isOpen()) {
      try {
        System.out.println("Garage door is closing...");
        Thread.sleep(2000);
        status = CLOSE;
        System.out.println("Garage door is closed.");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Garage door is close.");
    }
  }
}
