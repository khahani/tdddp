package designpattern.singleton.best;

public class Singleton {
  private volatile static Singleton uniqueInstance;

  private Singleton() {
  }

  public static Singleton getInstance() {

    if (Singleton.class.getClassLoader() != ClassLoader.getSystemClassLoader())
      throw new IllegalThreadStateException("The class loader is not the same as system class loader and it's not safe");

    if (uniqueInstance == null) {
      synchronized (Singleton.class) {
        if (uniqueInstance == null)
          uniqueInstance = new Singleton();
      }
    }
    return uniqueInstance;
  }
}
