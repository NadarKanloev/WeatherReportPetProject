package com.example.weatherreport_perproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {
    private final String API_KEY = "b91e5bc13e00446abfa193112230210";
    private final String API_URL = "http://api.weatherapi.com/v1/current.json?q={city}&key={apiKey}";
    private final RestTemplate restTemplate;
    public WeatherApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public String getWeatherByCity(String city){
        String apiUrl = API_URL.replace("{city}", city).replace("{apiKey}", API_KEY);
        String response = restTemplate.getForObject(apiUrl, String.class);
        return response;
    }
}
