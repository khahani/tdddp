package designpattern.observer.weatherStation.display;

import designpattern.observer.weatherStation.Subject;

public class StatisticsDisplay implements Observer, Display {
  private float temperature;
  private float humidity;
  private Subject weatherData;

  public StatisticsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    display();
  }

  @Override
  public void display() {
    System.out.println("Statistic Display: " + temperature + " temperature.");
  }
}
