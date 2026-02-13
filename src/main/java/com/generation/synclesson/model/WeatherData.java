package com.generation.synclesson.model;

public class WeatherData {


private double temperature;
private double windSpeed;


public WeatherData(double temperature, double windSpeed) {
this.temperature = temperature;
this.windSpeed = windSpeed;
}


public double getTemperature() {
return temperature;
}


public double getWindSpeed() {
return windSpeed;
}
}
