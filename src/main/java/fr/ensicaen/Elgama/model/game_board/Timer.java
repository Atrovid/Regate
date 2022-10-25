package fr.ensicaen.Elgama.model.game_board;

public class Timer {
    int _tSecInit;
    int _tMinInit;
    int _tMilliInit;
    int _tSecNow;
    int _tMinNow;
    int _tMilliNow;

    public Timer() {
        _tMilliInit = (int) System.currentTimeMillis();
        _tSecInit = (_tMilliInit/ 1000) % 60;
        _tMinInit = (_tMilliInit / 1000) / 60;


    }

    public void updateTimer() {
        _tMilliNow = (int) (System.currentTimeMillis() - _tMilliInit);
        _tSecNow = (_tMilliNow / 1000) % 60 - _tSecInit;
        _tMinNow = (_tMilliNow / 1000) / 60 - _tMinInit;
    }

    public int getTSecNow() {
        return _tSecNow;
    }

    public int getTMinNow() {
        return _tMinNow;
    }

    public int getTMilliNow() {
        return _tMilliNow;
    }

    public void resume() {
        _tMilliInit = (int) System.currentTimeMillis();
        _tSecInit =  (_tMilliInit/ 1000) % 60;
        _tMinInit =  (_tMilliInit / 1000) / 60;
    }
}
