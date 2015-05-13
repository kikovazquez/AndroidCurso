package vazquez.es.calculadora;

/**
 * Created by androidm on 07/05/2015.
 */

public interface MotorCalculadoraI {

    void setTotalizado(int totalizado);
    void setOperacion(String operacion);
    void setOperfinal(String operfinal);

    //int suma(String Valor);
    //int resta(String Valor);
    //int divide(String Valor);
    //int multiplica(String Valor);
    //int total(String Valor);
    int calcula(String Valor);



}
