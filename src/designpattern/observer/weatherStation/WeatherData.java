package designpattern.observer.weatherStation;

import designpattern.observer.weatherStation.display.Observer;

import java.util.ArrayList;

public class WeatherData implements Subject {

  private ArrayList<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  WeatherData() {
    observers = new ArrayList<>();
  }

  public void measurementsChanged() {
    notifyChanges();
  }

  @Override
  public void registerObserver(Observer ob) {
    observers.add(ob);
  }

  @Override
  public void removeObserver(Observer ob) {
    int i = observers.indexOf(ob);
    if (i >= 0)
      observers.remove(ob);
  }

  @Override
  public void notifyChanges() {
    for (Observer observer : observers) {
      observer.update(temperature, humidity, pressure);
    }
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
