package com.trevor.mexicodiveapp.data.apiWeather;

import com.trevor.mexicodiveapp.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiWeatherMapper {

    private Utils utils;

    @Autowired
    public ApiWeatherMapper(Utils utils) {
        this.utils = utils;
    }

    public Weather apiWeatherMapper(ApiWeatherResponse apiWeatherResponse) {
        Weather weather = new Weather();
        weather.setDescription(apiWeatherResponse.getWeather()[0].getDescription());
        weather.setTemp(utils.kelvinToCelsius(apiWeatherResponse.getMain().getTemp()));
        weather.setHumidity(apiWeatherResponse.getMain().getHumidity());
        weather.setMinTemp(utils.kelvinToCelsius(apiWeatherResponse.getMain().getTemp_min()));
        weather.setMaxTemp(utils.kelvinToCelsius(apiWeatherResponse.getMain().getTemp_max()));
        weather.setWindSpeed(apiWeatherResponse.getWind().getSpeed());
        weather.setCity(apiWeatherResponse.getName());
        return weather;
    }
}
