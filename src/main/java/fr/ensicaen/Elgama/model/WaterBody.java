package fr.ensicaen.Elgama.model;

import java.awt.geom.Point2D;

public class WaterBody {

    IWind _wind;
    Shoreline _shore;
    Buoy[] _buoyList;

    public WaterBody(IWind wind, Shoreline shore, Buoy[] buoyList) {
        this._wind = wind;
        this._shore = shore;
        this._buoyList = buoyList;
    }

    public Point2D getWindDirection() {
        return _wind.getWindDirection();
    }

    public float getWindForce() { return _wind.getWindForce(); }

    public Shoreline getShore() {
        return _shore;
    }

    public Buoy[] getBuoyList() {
        return _buoyList;
    }
}
