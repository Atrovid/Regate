package fr.ensicaen.Elgama.model.map;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class WeatherWind implements Wind {
    final private Point2D _GPSCoords;


    public WeatherWind(Point2D GPSCoordinates) throws IOException {
        _GPSCoords = GPSCoordinates;
        String data = fetchWeatherData();
        System.out.println(data);
        int index = data.indexOf("wnd_spd");
        System.out.println(data.substring(index, index + 30));
    }

    private String fetchWeatherData() throws IOException {
        URL url = new URL("https://www.prevision-meteo.ch/services/json/lat=49.283lng=-0.25");
        InputStream inputStream = url.openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder sBuilder = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sBuilder.append((char)cp);
        }
        return sBuilder.toString();
    }

    @Override
    public float getWindForce() {
        System.out.println(_GPSCoords);
        return 0;
    }

    @Override
    public Point2D getWindDirection() {
        return null;
    }
}
