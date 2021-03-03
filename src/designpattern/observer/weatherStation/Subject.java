package designpattern.observer.weatherStation;

import designpattern.observer.weatherStation.display.Observer;

public interface Subject {
  void registerObserver(Observer ob);

  void removeObserver(Observer ob);

  void notifyChanges();
}
