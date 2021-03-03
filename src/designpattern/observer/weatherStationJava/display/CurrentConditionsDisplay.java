package designpattern.observer.weatherStationJava.display;

import designpattern.observer.weatherStationJava.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, Display {

  Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Current Conditions: " + temperature
            + "F degrees and " + humidity + "%humidity");
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
