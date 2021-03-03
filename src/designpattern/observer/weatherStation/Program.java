package designpattern.observer.weatherStation;

import designpattern.observer.weatherStation.display.CurrentConditionsDisplay;
import designpattern.observer.weatherStation.display.StatisticsDisplay;

public class Program {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentDisplay =
            new CurrentConditionsDisplay(weatherData);

    StatisticsDisplay statisticsDisplay =
            new StatisticsDisplay(weatherData);

    weatherData.setMeasurements(80, 56, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
  }
}
