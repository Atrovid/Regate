package fr.ensicaen.elgama.model.map;

import fr.ensicaen.elgama.model.game_board.IWeatherDB;
import fr.ensicaen.elgama.model.game_board.WeatherWind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.geom.Point2D;

public class WeatherWindTest {
    @Test
    void getWindDirectionTest() {
        WeatherWind wind;
        IWeatherDB mockProxy = mock(IWeatherDB.class);
        try {
            when(mockProxy.requestData()).thenReturn("\"current_condition\":{\"date\":\"26.10.2022\",\"hour\":\"14:00\",\"tmp\":22,\"wnd_spd\":30,\"wnd_gust\":0,\"wnd_dir\":\"S\",\"pressure\":1011.7,\"humidity\":55,\"condition\":\"Ensoleill\\u00e9\"}");
            wind = new WeatherWind(mockProxy);
        } catch (Exception ignored) {
            return;
        }
        Point2D windDirection = wind.getWindDirection();
        Point2D expectedWindDirection = new Point2D.Float(0,1);
        assertEquals(expectedWindDirection.getX(),windDirection.getX());
        assertEquals(expectedWindDirection.getY(),windDirection.getY());

    }

    @Test
    void getWindForceTest() {
        WeatherWind wind;
        IWeatherDB mockProxy = mock(IWeatherDB.class);
        try {
            when(mockProxy.requestData()).thenReturn("\"current_condition\":{\"date\":\"26.10.2022\",\"hour\":\"14:00\",\"tmp\":22,\"wnd_spd\":30,\"wnd_gust\":0,\"wnd_dir\":\"S\",\"pressure\":1011.7,\"humidity\":55,\"condition\":\"Ensoleill\\u00e9\"}");
            wind = new WeatherWind(mockProxy);
        } catch (Exception ignored) {
            return;
        }
        float windForce = wind.getWindForce();
        assertTrue(windForce == 30);
    }
}
