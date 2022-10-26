package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Timer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimerTest {
    @Test
    void updateTest() {
        Timer t = new Timer();
        t.updateTimer();
        assertTrue((t.getMilliSecond()<1000));
        assertTrue((t.getSecond()<60));
    }
    @Test
    void resetTest() {
        Timer t = new Timer();
        t.updateTimer();
        t.reset();
        assertEquals(0, t.getSecond());
        assertTrue((t.getMilliSecond()==0));
        assertTrue((t.getMinute()==0));
    }

}

