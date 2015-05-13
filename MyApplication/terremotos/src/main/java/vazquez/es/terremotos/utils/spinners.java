package vazquez.es.terremotos.utils;

/**
 * Created by androidm on 13/05/2015.
 */
public class spinners {
    int id;
    String nombre;
    //Constructor
    spinners(){}
    public spinners(int id, String nombre){
        super();
        this.id = id;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }
    public int getId() {
        return id;
    }

}
