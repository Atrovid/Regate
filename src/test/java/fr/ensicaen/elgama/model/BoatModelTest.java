package fr.ensicaen.elgama.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class BoatModelTest {

    private static Point2D boat_point ;
    private static Point2D secondBoat_point;
    private static BoatModel boat ;
    private static BoatModel secondBoat;
    private static  BoatModel thirdBoat;

    @BeforeAll
    public static void oneTimeSetUp(){
        boat_point = new Point2D.Float(200,190);
        secondBoat_point = new Point2D.Float(0,-1);

        boat = new BoatModel();
        secondBoat = new BoatModel();
        thirdBoat = new  BoatModel();

    }

    @Test
    public void testScalar(){
        assertEquals(0,boat.scalarProduct(boat_point));
        boat.rotate(90);
        boat.move();

        assertEquals(200, boat.scalarProduct(boat_point));

        boat.rotate(90);
        boat.move();
        assertEquals(190,Math.round(boat.scalarProduct(boat_point)));
    }

    @Test
    public void testVectorialBetweenVectors(){
        assertEquals(0.0, secondBoat.productBetweenNorm(boat_point));

        secondBoat.rotate(56);
        secondBoat.move();

        assertEquals(275.86,secondBoat.productBetweenNorm(boat_point),0.1);

    }


    @Test
    public void testAngleBetweenWindAndBoat()
    {
        thirdBoat.move();
        assertEquals( 0.0, thirdBoat.angleBetweenWindAndBoat( secondBoat_point ) );
        thirdBoat.rotate(90);
        thirdBoat.move();
        //assertEquals( 90, thirdBoat.angleBetweenWindAndBoat( secondBoat_point ) );

    }

    @Test
    public void getBoatSpeedTest()
    {

    }

}
