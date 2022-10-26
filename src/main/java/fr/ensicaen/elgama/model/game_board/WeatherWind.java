package fr.ensicaen.elgama.model.game_board;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import java.lang.NumberFormatException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WeatherWind implements IWind {
    final private float _speed;
    final private Point2D _direction;
    final private IWeatherDB _proxy;

    public WeatherWind(IWeatherDB proxy) throws WeatherWindRequestFailureException {
        _proxy = proxy;
        String data;
        try {
            data = proxy.requestData();
        } catch (IOException e) {
            throw new WeatherWindRequestFailureException(e.getMessage());
        }
        String SPEED_FIELD_NAME = "\"wnd_spd\":";
        String DIRECTION_FIELD_NAME = "\"wnd_dir\":";
        String speedString = extractFieldValue(data, SPEED_FIELD_NAME);
        try {
            _speed = Float.parseFloat(speedString);
        } catch (NumberFormatException e) {
            throw new WeatherWindRequestFailureException(e.getMessage());
        }
        String directionString = extractFieldValue(data, DIRECTION_FIELD_NAME);
        _direction = interpretDirection(directionString);
    }

    private Point2D interpretDirection(String direction) {
        Map<Character, Point2D> map = new HashMap<>();
        map.put('N', new Point2D.Double(0,-1));
        map.put('S', new Point2D.Double(0,1));
        map.put('E', new Point2D.Double(1,0));
        map.put('O', new Point2D.Double(-1,0));
        double x = 0;
        double y = 0;
        for (char c: direction.toCharArray()) {
            if (map.containsKey(c)) {
                x += map.get(c).getX();
                y += map.get(c).getY();
            }
        }
        double norm = Point2D.distance(x,y, 0,0);
        return new Point2D.Double(x / norm, y / norm);
    }

    private String extractFieldValue(String data, String fieldName) {
        int indexStart = data.indexOf(fieldName);
        int indexEnd = data.indexOf(',', indexStart);
        return data.substring(indexStart + fieldName.length(), indexEnd);
    }

    @Override
    public float getWindForce() {
        return _speed;
    }

    @Override
    public Point2D getWindDirection() {
        return _direction;
    }
}
