package vazquez.es.terremotos.modelo;

import java.util.LinkedList;

/**
 * Created by Kiko on 14/05/2015.
 */
public class Terremotos {
    private LinkedList<Terremoto> AllTerremotos;

    public LinkedList<Terremoto> getAllTerremotos() {
        return AllTerremotos;
    }

    public void setrremotos(LinkedList<Terremoto> allTerremotos) {
        AllTerremotos = allTerremotos;
    }
}
