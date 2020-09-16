package ch.zhaw.gpi.csbtemplate.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private List<WeatherEntry> consolidated_weather = new ArrayList<>();

    public List<WeatherEntry> getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(List<WeatherEntry> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    
}