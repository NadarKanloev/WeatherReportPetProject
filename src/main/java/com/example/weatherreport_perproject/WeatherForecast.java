package com.example.weatherreport_perproject;

import jakarta.persistence.*;

@Entity
@Table(name = "weather")
public class WeatherForecast {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column
    private String city;
    @Column
    private double temperature;
    @Column
    private double humidity;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getHumidity(){
        return humidity;
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
    }
}
