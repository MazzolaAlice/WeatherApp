package com.generation.synclesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.synclesson.client.OpenMeteoClient;
import com.generation.synclesson.dto.WeatherResponse;

@Service
public class WeatherService {

    @Autowired
    private OpenMeteoClient openMeteoClient;

    /**
     * Recupera dati meteo a partire dal nome città.
     *
     * Step:
     * 1) Geocoding città → lat/lon
     * 2) Chiamata meteo
     */
    public WeatherResponse getWeatherByCity(String city) {
        return openMeteoClient.fetchWeather(city);
    }
}
