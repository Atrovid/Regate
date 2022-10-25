package fr.ensicaen.elgama.model;

import fr.ensicaen.elgama.model.game_board.Timer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimerTest {
    @Test
    void updateTest() throws InterruptedException {
        Timer t = new Timer();
        t.updateTimer();
        int milliInit = t.getTMilliNow();
        TimeUnit.SECONDS.sleep(10);
        t.updateTimer();
        assertTrue((t.getTMilliNow()!=milliInit));
    }
    @Test
    void resumeTest() throws InterruptedException {
        Timer t = new Timer();

        TimeUnit.SECONDS.sleep(10);
        t.updateTimer();
        int sec2 = t.getTSecNow();
        t.resume();
        t.updateTimer();
        assertTrue((sec2 != t.getTSecNow()));
    }

}

