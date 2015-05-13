package vazquez.es.calculadora;

import android.app.Application;

/**
 * Created by androidm on 11/05/2015.
 */
public class Inicio extends Application {
    private MotorCalculadoraI calculadora;


    @Override
    public void onCreate() {
        super.onCreate();
        calculadora = new MotorCalculadora();
    }

    public MotorCalculadoraI getCalculadora() {
        return calculadora;
    }


}
