package fr.ensicaen.elgama.model.game_board;

public class Timer {

    private int _tSecInit;
    private int _tMinInit;
    private int _tMilliInit;
    private int _tSecNow;
    private int _tMilliNow;

    public Timer() {
        _tMilliInit = (int) System.currentTimeMillis();
        _tSecInit = (_tMilliInit / 1000) % 60;
        _tMinInit = (_tMilliInit / 1000) / 60;
    }

    public void updateTimer() {
        _tMilliNow = (int) (System.currentTimeMillis() - _tMilliInit);
        _tSecNow = (_tMilliNow / 1000) % 60 - _tSecInit;
        int _tMinNow = (_tMilliNow / 1000) / 60 - _tMinInit;
    }

    public int getTSecNow() {
        return _tSecNow;
    }

    public int getTMilliNow() {
        return _tMilliNow;
    }

    public void resume() {
        _tMilliInit = (int) System.currentTimeMillis();
        _tSecInit = (_tMilliInit / 1000) % 60;
        _tMinInit = (_tMilliInit / 1000) / 60;
    }
}
