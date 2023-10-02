package com.example.weatherreport_perproject.Controllers;

import com.example.weatherreport_perproject.Services.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherApiService weatherApiService;
    @Autowired
    public WeatherController(WeatherApiService weatherApiService){
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city){
        return weatherApiService.getWeatherByCity(city);
    }
}
