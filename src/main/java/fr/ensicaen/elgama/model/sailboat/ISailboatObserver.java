package fr.ensicaen.elgama.model.sailboat;


public interface ISailboatObserver {
    Sailboat[] _boatModelList = new Sailboat[0];


    Object observer(Sailboat changed, Object o);

}
