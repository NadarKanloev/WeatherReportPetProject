package com.example.weatherreport_perproject.controller;

import com.example.weatherreport_perproject.model.WeatherForecast;
import com.example.weatherreport_perproject.repository.WeatherForecastRepository;
import com.example.weatherreport_perproject.service.WeatherApiService;
import com.example.weatherreport_perproject.service.WeatherJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WeatherRestController {
    private final WeatherForecastRepository weatherForecastRepository;
    private final WeatherApiService weatherApiService;
    @Autowired
    public WeatherRestController(WeatherApiService weatherApiService, WeatherForecastRepository weatherForecastRepository){
        this.weatherApiService = weatherApiService;
        this.weatherForecastRepository = weatherForecastRepository;
    }
    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city){
        String weatherJSON = weatherApiService.getWeatherByCity(city);

        double temperature = WeatherJsonParser.parseTemperatureFromJSON(weatherJSON);
        int humidity = WeatherJsonParser.parseHumidityFromJSON(weatherJSON);

        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setCity(city);
        weatherForecast.setTemperature(temperature);
        weatherForecast.setHumidity(humidity);
        weatherForecast.setDate(new Date());

        weatherForecastRepository.save(weatherForecast);

        return weatherJSON;
    }
}
