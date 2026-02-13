package com.generation.synclesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.synclesson.dto.WeatherResponse;
import com.generation.synclesson.service.WeatherService;

/**
 * Controller MVC che gestisce:
 * - Visualizzazione pagina iniziale
 * - Invio richiesta meteo
 */
@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Mostra la homepage con il form di ricerca.
     */
    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html
    }

    /**
     * Riceve il nome città dal form HTML.
     *
     * @param city Nome città inserito dall'utente
     * @param model Oggetto per passare dati al frontend
     */
    @GetMapping("/weather")
    public String getWeather(
            @RequestParam String city,
            Model model
    ) {
        WeatherResponse response = weatherService.getWeatherByCity(city);

        model.addAttribute("weather", response);
        model.addAttribute("city", city);

        return "index";
    }
}
