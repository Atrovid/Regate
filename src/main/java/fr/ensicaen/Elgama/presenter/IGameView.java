package fr.ensicaen.Elgama.presenter;

import fr.ensicaen.Elgama.model.WaterBody;

public interface IGameView {
    void addBoat( double x, double y );

    void drawWaterBody(WaterBody map);

    void update( double dx, double dy, double angle );
}
