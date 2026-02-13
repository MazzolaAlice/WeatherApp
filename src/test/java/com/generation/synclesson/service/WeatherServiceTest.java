package com.generation.synclesson.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.generation.synclesson.client.OpenMeteoClient;
import com.generation.synclesson.dto.CurrentWeather;
import com.generation.synclesson.dto.WeatherResponse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Test unitari per WeatherService.
 * Testa solo la logica, NON le chiamate reali API.
 */
public class WeatherServiceTest {

    // Simula il client API
    @Mock
    private OpenMeteoClient openMeteoClient;

    // Inietta il mock dentro il service
    @InjectMocks
    private WeatherService weatherService;

    /**
     * Inizializza i mock prima di ogni test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test: verifica che il service restituisca
     * correttamente i dati meteo.
     */
    @Test
    void testGetWeatherByCity() {

        // Creo dati finti
        CurrentWeather current = new CurrentWeather();
        current.setTemperature(20.5);
        current.setWindspeed(10.0);

        WeatherResponse mockResponse = new WeatherResponse();
        mockResponse.setCurrent_weather(current);

        // Definisco comportamento mock
        when(openMeteoClient.fetchWeather("Rome"))
                .thenReturn(mockResponse);

        // Chiamo il service reale
        WeatherResponse result =
                weatherService.getWeatherByCity("Rome");

        // Verifiche
        assertNotNull(result);
        assertEquals(20.5,
                result.getCurrent_weather().getTemperature());
    }
}
