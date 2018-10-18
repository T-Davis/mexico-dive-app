package com.trevor.mexicodiveapp.presentation;

import com.trevor.mexicodiveapp.logic.model.apiWeather.ApiWeatherResponse;
import com.trevor.mexicodiveapp.logic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{city}")
    public ApiWeatherResponse getWeatherByCity(@PathVariable("city") String location) {
        return weatherService.getResult(location);
    }


}
