package vazquez.es.parsexml;

import java.util.Date;

/**
 * Created by androidm on 20/05/2015.
 */
public class Terremoto {
    private String id;
    private String titulo;
    private Float magnitud;
    private String link;
    private Date fecha;
    private Float latitud;
    private Float longitud;

    public Terremoto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terremoto terremoto = (Terremoto) o;

        return !(id != null ? !id.equals(terremoto.id) : terremoto.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Terremoto{" +
                "titulo='" + titulo + '\'' +
                ", magnitud=" + magnitud +
                ", fecha=" + fecha +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(Float magnitud) {
        this.magnitud = magnitud;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }
}
