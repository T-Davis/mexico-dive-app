package com.trevor.mexicodiveapp.data.weatherApi;

import com.trevor.mexicodiveapp.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiMapper {

    private Utils utils;

    @Autowired
    public WeatherApiMapper(Utils utils) {
        this.utils = utils;
    }

    public Weather apiWeatherMapper(WeatherApiResponse weatherApiResponse) {
        Weather weather = new Weather();
        weather.setDescription(weatherApiResponse.getWeather()[0].getDescription());
        weather.setTemp(utils.kelvinToCelsius(weatherApiResponse.getMain().getTemp()));
        weather.setHumidity(weatherApiResponse.getMain().getHumidity());
        weather.setMinTemp(utils.kelvinToCelsius(weatherApiResponse.getMain().getTemp_min()));
        weather.setMaxTemp(utils.kelvinToCelsius(weatherApiResponse.getMain().getTemp_max()));
        weather.setWindSpeed(weatherApiResponse.getWind().getSpeed());
        weather.setCity(weatherApiResponse.getName());
        return weather;
    }
}
