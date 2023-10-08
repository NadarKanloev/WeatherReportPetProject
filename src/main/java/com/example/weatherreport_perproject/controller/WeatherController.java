package com.example.weatherreport_perproject.controller;

import com.example.weatherreport_perproject.model.WeatherForecast;
import com.example.weatherreport_perproject.repository.WeatherForecastRepository;
import com.example.weatherreport_perproject.service.WeatherForecastService;
import com.example.weatherreport_perproject.service.WeatherJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class WeatherController {

    private final WeatherForecastRepository weatherForecastRepository;
    public final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherController(WeatherForecastRepository weatherForecastRepository, WeatherForecastService weatherForecastService){
        this.weatherForecastRepository = weatherForecastRepository;
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/weatherForecast/{city}")
    public String getWeather(Model model, @PathVariable String city){
        WeatherForecast weatherForecast = weatherForecastService.getLatestWeatherForecast(city);
        double temp = weatherForecast.getTemperature();
        double humidity = weatherForecast.getHumidity();

        model.addAttribute("temperature", temp);
        model.addAttribute("humidity", humidity);
        model.addAttribute("city", city);

        return "weather";
    }
}
