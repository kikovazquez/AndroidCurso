package vazquez.es.fragmentos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by androidm on 14/05/2015.
 */
public class Tarea implements Serializable {
    private String nombre;
    private String descripcion;
    private int prioridad;
    private Date fecha;

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tarea(String nombre, String descripcion, int prioridad, Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = fecha;
    }

    public Tarea() {
    }

}
