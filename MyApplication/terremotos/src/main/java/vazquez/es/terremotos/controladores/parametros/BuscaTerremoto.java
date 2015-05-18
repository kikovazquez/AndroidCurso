package vazquez.es.terremotos.controladores.parametros;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by androidm on 13/05/2015.
 */
public class BuscaTerremoto implements Serializable {
    private int magnitudTerremoto;
    private Date fechaABuscar;

    public Date getFechaABuscar() {
        return fechaABuscar;
    }

    public void setFechaABuscar(Date fechaABuscar) {
        this.fechaABuscar = fechaABuscar;
    }

    public BuscaTerremoto() {
    }

    public BuscaTerremoto(int magnitudTerremoto, Date fechaABuscar) {
        this.magnitudTerremoto = magnitudTerremoto;
        this.fechaABuscar = fechaABuscar;
    }

    public int getMagnitudTerremoto() {
        return magnitudTerremoto;
    }

    public void setMagnitudTerremoto(int magnitudTerremoto) {
        this.magnitudTerremoto = magnitudTerremoto;
    }
}
