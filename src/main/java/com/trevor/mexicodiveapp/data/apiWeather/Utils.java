package com.trevor.mexicodiveapp.data.apiWeather;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public Double kelvinToCelsius(Double degreesInKelvin) {
        long roundToNearest = Math.round((degreesInKelvin - 273.15) * 100);
        return (double) (roundToNearest / 100);
    }
}
