package com.example.weatherreport_perproject.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

public class WeatherJsonParser {
    public static double parseTemperatureFromJSON(String JSON){
        try {
            JSONObject jsonpObject = new JSONObject(JSON);
            JSONObject currentObject = jsonpObject.getJSONObject("current");
            return currentObject.getDouble("temp_c");

        } catch (Exception e){
            e.printStackTrace();
            return 0.0;
        }
    }

    public static int parseHumidityFromJSON(String JSON){
        try {
            JSONObject jsonObject = new JSONObject(JSON);
            JSONObject currentObject = jsonObject.getJSONObject("current");
            return currentObject.getInt("humidity");

        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
