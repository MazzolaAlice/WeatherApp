package com.generation.synclesson.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoResponse {

    private List<GeoResult> results;

    public List<GeoResult> getResults() {
        return results;
    }

    public void setResults(List<GeoResult> results) {
        this.results = results;
    }
}
