package com.example.weatherreport_perproject.service;

import com.example.weatherreport_perproject.model.WeatherForecast;
import com.example.weatherreport_perproject.repository.WeatherForecastRepository;
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

    public WeatherForecast getLatestWeatherForecast(String city){
        Optional<WeatherForecast> latestWeatherOptional = forecastRepository.findFirstByCityOrderByDateDesc(city);
        return latestWeatherOptional.orElse(null);
    }
}


