package com.example.weatherreport_perproject.Services;

import com.example.weatherreport_perproject.WeatherForecast;
import com.example.weatherreport_perproject.Repositories.WeatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherForecastService{
    private final WeatherForecastRepository forecastRepository;

    @Autowired
    public WeatherForecastService(WeatherForecastRepository forecastRepository){
        this.forecastRepository = forecastRepository;
    }

    public Optional<WeatherForecast> getWeatherByCity(String city){
        return forecastRepository.findByCity(city);
    }
}


