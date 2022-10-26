package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.sailboat.PolarReader;
import fr.ensicaen.elgama.model.sailboat.SailboatPolar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SailboatPolarTest {
    private PolarReader.PolarType _polarType = PolarReader.PolarType.Figaro;

    @Test
    void giveGoodMaxSpeed() {
        SailboatPolar sailboatPolar = new SailboatPolar( _polarType );
        assertEquals( 6.60, sailboatPolar.getMaxSpeed( 60, 16) );
    }
}
