package vazquez.es.calculadora;

import java.util.Locale;

/**
 * Created by androidm on 07/05/2015.
 */
public class MotorCalculadora implements MotorCalculadoraI {

    private int totalizado = 0;
    private String operacion ="";
    private String operfinal ="";

    public int getTotalizado() {
        return totalizado;
    }

    public void setTotalizado(int totalizado) {
        this.totalizado = totalizado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperfinal() {
        return operfinal;
    }

    public void setOperfinal(String operfinal) {
        this.operfinal = operfinal;
    }


    private int suma(String valor) {

        return Integer.parseInt(valor) + totalizado ;
    }

    private int resta(String valor) {
        return  totalizado - Integer.parseInt(valor)  ;

    }

    private int divide(String valor) {
        if (Integer.parseInt(valor) == 0 ) {
            return  0;
        }
        return  totalizado / Integer.parseInt(valor)  ;
    }

    private int multiplica(String valor) {
        return Integer.parseInt(valor) * totalizado ;
    }

    private int total(String valor) {
        if (operacion.equals("+")) {
            return suma(valor);
        }else if (operacion.equals("-")) {
            return resta(valor);
        }else if (operacion.equals("*")) {
            return multiplica(valor);
        }else if(operacion.equals("/")) {
            return divide(valor);
        }
        return 0;

    }
    @Override
    public int calcula(String valor) {
        if (operfinal.equals("+")) {
            return suma(valor);
        }else if (operfinal.equals("-")) {
            return resta(valor);
        }else if (operfinal.equals("*")) {
            return multiplica(valor);
        }else if(operfinal.equals("/")) {
            return divide(valor);
        }
        return Integer.parseInt(valor);

    }


}
