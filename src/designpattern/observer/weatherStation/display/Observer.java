package designpattern.observer.weatherStation.display;

public interface Observer {
  void update(float temperature, float humidity, float pressure);
}
