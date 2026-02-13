package com.generation.synclesson.dto;

import java.util.List;

/**
 * DTO che rappresenta le previsioni giornaliere.
 */
public class Daily {

    private List<String> time;
    private List<Double> temperature_2m_max;
    private List<Double> temperature_2m_min;

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(List<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public List<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(List<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }
}
