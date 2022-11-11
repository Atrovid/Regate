package fr.ensicaen.elgama.model.game_board;

import java.util.Iterator;

public class CheckPointIterator implements Iterator<CheckPoint> {
    private final CheckPoint[] checkPointList;
    private int _currentIndex = 0;

    public CheckPointIterator(CheckPoint[] cpList) {
        checkPointList = cpList;
    }

    public boolean hasNext() {
        return _currentIndex < checkPointList.length;
    }

    public CheckPoint next() {
        return checkPointList[_currentIndex++];
    }
}
