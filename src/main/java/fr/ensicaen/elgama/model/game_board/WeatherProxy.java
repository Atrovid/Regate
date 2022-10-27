package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WeatherProxy implements IWeatherDB{

    final private Point2D _GPSCoords;

    public WeatherProxy(Point2D gps){
        _GPSCoords = gps;
    }

    public String requestData() throws IOException {
        String URL_TEMPLATE = "https://www.prevision-meteo.ch/services/json/lat=%flng=%f";
        String urlString = String.format(URL_TEMPLATE, _GPSCoords.getX(), _GPSCoords.getY());
        urlString = urlString.replace(',','.'); //sinon l'url est faux
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder sBuilder = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sBuilder.append((char)cp);
        }
        return sBuilder.toString();
    }
}
