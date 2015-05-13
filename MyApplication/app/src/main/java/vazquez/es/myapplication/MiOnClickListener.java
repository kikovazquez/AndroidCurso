package vazquez.es.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by androidm on 07/05/2015.
 */
public class MiOnClickListener implements View.OnClickListener {
    private Button boton;
    public MiOnClickListener(){

    }
    public MiOnClickListener(Button boton1) {
        this.boton = boton1;
    }

    @Override
    public void onClick(View view) {
            Log.i("app", "click boton 1!");
            this.boton.setText("cambiado");
    }
}
