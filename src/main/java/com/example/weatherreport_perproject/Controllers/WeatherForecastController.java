package com.example.weatherreport_perproject.Controllers;

import com.example.weatherreport_perproject.WeatherForecast;
import com.example.weatherreport_perproject.Services.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/weather")
public class WeatherForecastController{
    private final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherForecastController(WeatherForecastService weatherForecastService){
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherForecast> getWeatherByCity(@PathVariable String city){
        Optional<WeatherForecast> forecast = weatherForecastService.getWeatherByCity(city);
        return forecast.map(weather -> ResponseEntity.ok().body(weather))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
