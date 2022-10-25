package fr.ensicaen.elgama.model.game_board;

public class Board {
    private final Shoreline _shore;
    private final Buoy[] _buoyList;
    private final CheckPoint[] _checkPointList;

    public Board(IWind wind, Shoreline shore, Buoy[] buoyList, CheckPoint[] checkPointList) {
        _shore = shore;
        _buoyList = buoyList;
        _checkPointList = checkPointList;
    }

    public Object accept(IBoardElementVisitor visitor, Object o) {
        Object result = _shore.accept(visitor, o);
        for (Buoy b : _buoyList) {
            result = b.accept(visitor, result);
        }
        for (CheckPoint cp : _checkPointList) {
            result = cp.accept(visitor, result);
        }
        return result;
    }
}
