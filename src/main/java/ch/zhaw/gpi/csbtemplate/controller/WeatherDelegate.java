package ch.zhaw.gpi.csbtemplate.controller;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import ch.zhaw.gpi.csbtemplate.model.Weather;

@Named("GetWeatherDelegate")
public class WeatherDelegate implements JavaDelegate {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void execute(DelegateExecution e) throws Exception {
        
        Weather w = restTemplate.getForObject("https://www.metaweather.com/api/location/784794/", Weather.class);
        System.out.println("Weather Report: " + w.getConsolidated_weather().get(0).getWeather_state_name());
        
        String wa = w.getConsolidated_weather().get(0).getWeather_state_abbr();
        // String wa = "c";
        if(!wa.equalsIgnoreCase("c")) {
            e.setVariable("weather", "cloudy");
        }
        else {
            e.setVariable("weather", "clear");
        }
        e.setVariable("certainty", Integer.parseInt(w.getConsolidated_weather().get(0).getPredictability()));
        System.out.println("Weather: " + e.getVariable("weather"));
        System.out.println("Certainty: " + e.getVariable("certainty"));
       
    }
}