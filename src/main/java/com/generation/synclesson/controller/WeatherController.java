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
    public String home(Model model) {
        model.addAttribute("bgClass", "mild");
        return "index"; // templates/index.html
    }

    /**
     * Riceve il nome città dal form HTML.
     *
     * @param city Nome città inserito dall'utente
     * @param model Oggetto per passare dati al frontend
     */
@GetMapping("/weather")
public String getWeather(@RequestParam String city, Model model) {

    try {
        
        WeatherResponse weather =
                weatherService.getWeatherByCity(city);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city); 
        double temp =
                        weather.getCurrent_weather().getTemperature();
         String bgClass;

        if (temp <= 10) {
            bgClass = "cold";
        } else if (temp >= 25) {
            bgClass = "hot";
        } else {
            bgClass = "mild";
        }
        model.addAttribute("bgClass", bgClass);

    } catch (RuntimeException ex) {

        // Messaggio errore da mostrare in pagina
        model.addAttribute("error",
                "Città non trovata. Riprova.");
                model.addAttribute("bgClass", "mild");

    }
    return "index";
}
}
