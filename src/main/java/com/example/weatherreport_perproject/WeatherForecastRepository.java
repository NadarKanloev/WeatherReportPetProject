package com.example.weatherreport_perproject;

import java.util.Optional;

public interface WeatherForecastRepository {
    Optional<WeatherForecast> findByCity(String city);
}
