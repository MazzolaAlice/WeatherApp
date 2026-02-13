package com.generation.synclesson.client;

import com.generation.synclesson.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Client per chiamate Open-Meteo + Geocoding.
 */
@Component
public class OpenMeteoClient {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse fetchWeather(String city) {

    // 1️⃣ GEOCODING URL
    String geoUrl =
            "https://geocoding-api.open-meteo.com/v1/search?name="
                    + city + "&count=1";

    GeoResponse geoResponse =
            restTemplate.getForObject(geoUrl, GeoResponse.class);

    if (geoResponse == null
            || geoResponse.getResults() == null
            || geoResponse.getResults().isEmpty()) {

        throw new RuntimeException("Città non trovata");
    }

    // 2️⃣ PRENDO COORDINATE
    double lat =
            geoResponse.getResults().get(0).getLatitude();

    double lon =
            geoResponse.getResults().get(0).getLongitude();

    // 3️⃣ FORECAST URL (QUI USI lat/lon)
    String weatherUrl =
            "https://api.open-meteo.com/v1/forecast?"
                    + "latitude=" + lat
                    + "&longitude=" + lon
                    + "&current_weather=true"
                    + "&daily=temperature_2m_max,temperature_2m_min"
                    + "&timezone=auto";

    // 4️⃣ CHIAMATA METEO
    WeatherResponse weatherResponse =
            restTemplate.getForObject(
                    weatherUrl,
                    WeatherResponse.class
            );

    return weatherResponse;
}
}