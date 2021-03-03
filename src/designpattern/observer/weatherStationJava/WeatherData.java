package designpattern.observer.weatherStationJava;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {

  private ArrayList<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemperture() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }
}
