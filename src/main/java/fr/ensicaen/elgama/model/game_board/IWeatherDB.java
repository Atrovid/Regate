package fr.ensicaen.elgama.model.game_board;

import java.io.IOException;

public interface IWeatherDB {
    String requestData() throws IOException;
}
