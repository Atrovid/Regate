package fr.ensicaen.Elgama.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BoatModelTest {

    private static Point2D boat_point ;
    private static BoatModel boat ;

    @BeforeAll
    public static void oneTimeSetUp(){
        boat_point = new Point2D.Float(200,190);
        boat = new BoatModel();


    }

    @Test
    public void testScalar(){
        assertEquals(0,boat.scalar(boat_point));
        boat.rotate(90);
        boat.move();
        assertEquals(200, boat.scalar(boat_point));

        boat.rotate(90);
        boat.move();
        assertEquals(190,Math.round(boat.scalar(boat_point)));
    }


}