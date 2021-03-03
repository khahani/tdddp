package designpattern.observer.weatherStationJava.display;

import designpattern.observer.weatherStationJava.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, Display {
  private final Observable observable;
  private float temperature;
  private float humidity;

  public StatisticsDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Statistic Display: " + temperature + " temperature.");
  }

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WeatherData) {
      WeatherData weatherData = (WeatherData) o;
      this.temperature = weatherData.getTemperture();
      this.humidity = weatherData.getHumidity();
      display();
    }
  }
}
