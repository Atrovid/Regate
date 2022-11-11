package fr.ensicaen.elgama.model.sailboat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolReaderTest {

    @Test
    void does_polar_reader_return_the_good_values() {
        PolarReader pol = new PolarReader(PolarReader.PolarType.Figaro);
        double[][] data = pol.loadData();
        assertEquals(0.00, data[0][0]);
        assertEquals(9.00, data[18][13]);
        assertEquals(8.00, data[7][5]);
    }
}
