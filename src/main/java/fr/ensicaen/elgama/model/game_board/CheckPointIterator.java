package fr.ensicaen.elgama.model.game_board;

import java.util.Iterator;

public class CheckPointIterator implements Iterator<CheckPoint>{

    private int _current = 0;
    private final CheckPoint[] _cpList;

    public CheckPointIterator(CheckPoint[] cpList) {
        _cpList = cpList;
    }
    public boolean hasNext() {
        return _cpList[_current+1] == null;
    }

    public CheckPoint next() {
        _current ++;
        return _cpList[_current];
    }

}
