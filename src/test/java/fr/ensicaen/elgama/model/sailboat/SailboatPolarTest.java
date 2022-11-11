package fr.ensicaen.elgama.model.sailboat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SailboatPolarTest {
    private final PolarReader.PolarType _polarType = PolarReader.PolarType.Figaro;

    @Test
    void giveGoodMaxSpeed() {
        SailboatPolar sailboatPolar = new SailboatPolar(_polarType);
        assertEquals(7.80, sailboatPolar.getMaxSpeed(60, 16));
        assertEquals(1.0, sailboatPolar.getMaxSpeed(175, 3));
        assertEquals(9.0, sailboatPolar.getMaxSpeed(175, 40));

    }
}
