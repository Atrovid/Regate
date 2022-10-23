package fr.ensicaen.Elgama.model.game_board;

public class Timer {
    int tSecInit;
    int tMinInit;
    int tMilliInit;
    int tSecNow;
    int tMinNow;
    int tMilliNow;

    public Timer() {
        this.tMilliInit = (int) System.currentTimeMillis();
        this.tSecInit = (tMilliInit/ 1000) % 60;
        this.tMinInit = (tMilliInit / 1000) / 60;


    }

    public void updateTimer() {
        tMilliNow = (int) (System.currentTimeMillis() - tMilliInit);
        tSecNow = (tMilliNow / 1000) % 60 - tSecInit;
        tMinNow = (tMilliNow / 1000) / 60 - tMinInit;
    }

    public int getTSecNow() {
        return tSecNow;
    }

    public int getTMinNow() {
        return tMinNow;
    }

    public int getTMilliNow() {
        return tMilliNow;
    }

    public void resume() {
        tMilliInit = (int) System.currentTimeMillis();
        tSecInit =  (tMilliInit/ 1000) % 60;
        tMinInit =  (tMilliInit / 1000) / 60;
    }
}
