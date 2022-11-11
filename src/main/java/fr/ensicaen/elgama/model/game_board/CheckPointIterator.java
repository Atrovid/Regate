package fr.ensicaen.elgama.model.game_board;

import java.util.Iterator;

public class CheckPointIterator implements Iterator<CheckPoint>{
    private int _currentIndex = 0;
    private final CheckPoint[] checkPointList;

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
