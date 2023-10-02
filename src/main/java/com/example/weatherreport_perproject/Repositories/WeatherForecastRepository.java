package com.example.weatherreport_perproject.Repositories;

import com.example.weatherreport_perproject.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
    Optional<WeatherForecast> findByCity(String city);
}
