package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherWind extends Wind {
    final private float _speed;
    final private Point2D _direction;

    public WeatherWind(IWeatherDB proxy) throws WeatherWindRequestFailureException {
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
        map.put('N', new Point2D(0, -1));
        map.put('S', new Point2D(0, 1));
        map.put('E', new Point2D(1, 0));
        map.put('O', new Point2D(-1, 0));
        double x = 0;
        double y = 0;
        for (char c : direction.toCharArray()) {
            if (map.containsKey(c)) {
                x += map.get(c).getX();
                y += map.get(c).getY();
            }
        }
        Point2D currentPoint = new Point2D(x, y);
        double norm = currentPoint.distance(0, 0);
        return new Point2D(x / norm, y / norm);
    }

    private String extractFieldValue(String data, String fieldName) {
        int indexStart = data.indexOf(fieldName);
        int indexEnd = data.indexOf(',', indexStart);
        return data.substring(indexStart + fieldName.length(), indexEnd);
    }

    @Override
    public float getWindStrength() {
        return _speed;
    }

    @Override
    public Point2D getWindDirectionPoint2D() {
        return _direction;
    }

    @Override
    public double getWindDirectionDouble() {
        return Wind.windDirectionAngle(_direction);
    }
}
