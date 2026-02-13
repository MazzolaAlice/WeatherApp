package com.generation.synclesson.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.generation.synclesson.dto.CurrentWeather;
import com.generation.synclesson.dto.WeatherResponse;
import com.generation.synclesson.service.WeatherService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test MVC del WeatherController.
 *
 * Avvia solo il layer web (NON tutta l’app).
 */
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    /**
     * MockMvc simula richieste HTTP.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Mock del Service.
     * Evita chiamate reali API.
     */
    @MockitoBean
    private WeatherService weatherService;

    /**
     * Test endpoint /weather con città valida.
     */
    @Test
    void testGetWeather() throws Exception {

        // Creo dati meteo finti
        CurrentWeather current = new CurrentWeather();
        current.setTemperature(22.0);
        current.setWindspeed(12.0);

        WeatherResponse response = new WeatherResponse();
        response.setCurrent_weather(current);

        // Definisco comportamento mock
        Mockito.when(
            weatherService.getWeatherByCity("Rome")
        ).thenReturn(response);

        // Simulo richiesta GET
        mockMvc.perform(
                get("/weather")
                .param("city", "Rome")
         )

        // Verifiche
        .andExpect(status().isOk())              // HTTP 200
        .andExpect(view().name("index"))         // View Thymeleaf
        .andExpect(model().attributeExists("weather"))
        .andExpect(model().attribute("city", "Rome"));
    }
}
