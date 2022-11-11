package fr.ensicaen.elgama.model.race_manager;

public class Timer {
    private int _milliSecondInit;
    private int _milliSecondElapsed;

    public Timer() {
        _milliSecondInit = (int) System.currentTimeMillis();
    }

    public void updateTimer() {
        _milliSecondElapsed = (int) (System.currentTimeMillis() - _milliSecondInit);
    }

    private int getSecondElapsed() {
        return _milliSecondElapsed / 1000;
    }

    public int getMilliSecond() {
        return _milliSecondElapsed % 1000;
    }

    public int getSecond() {
        return getSecondElapsed() % 60;
    }

    public int getMinute() {
        return getSecondElapsed() / 60;
    }

    public void reset() {
        _milliSecondInit = (int) System.currentTimeMillis();
        this.updateTimer();
    }
}
