package fr.ensicaen.elgama.model.game_board;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckPointIteratorTest {

    @Test
    void testCheckPointIteratorEmpty() {
        CheckPoint[] cps = {};
        CheckPointIterator iter = new CheckPointIterator(cps);
        assertFalse(iter.hasNext());
    }

    @Test
    void testCheckPointIteratorStandardUseCase() {
        CheckPoint[] cps = {
                new CheckPoint(new Point2D(0, 0), new Point2D(1, 1)),
                new CheckPoint(new Point2D(10, 10), new Point2D(20, 20))
        };
        CheckPointIterator iter = new CheckPointIterator(cps);
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertFalse(iter.hasNext());
    }

}