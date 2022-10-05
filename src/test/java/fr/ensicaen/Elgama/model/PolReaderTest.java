package fr.ensicaen.Elgama.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PolReaderTest {

    @Test
    void does_polar_reader_return_the_good_values(){
        PolReader pol = new PolReader();
        double data[][] = pol.loadData();
        assertTrue(data[0][0]==0.00);
        assertTrue(data[18][13]==9.00);
        assertTrue(data[7][5]==8.00);
    }
}
