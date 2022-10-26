package fr.ensicaen.elgama.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.geometry.Point2D;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BoatModelTest {

    @Test
    public void testAngleToVector() {
        BoatModel b = new BoatModel();
        assertEquals(0, b.angleToVector(0).distance(new Point2D(0, -1)), 0.000001);
        assertEquals(0, b.angleToVector(45).distance(new Point2D(1, -1).normalize()), 0.000001);
        assertEquals(0, b.angleToVector(180).distance(new Point2D(0, 1)), 0.000001);
        assertEquals(0, b.angleToVector(225).distance(new Point2D(-1, 1).normalize()), 0.000001);
        assertEquals(0, b.angleToVector(270).distance(new Point2D(-1, 0)), 0.000001);
    }


}
