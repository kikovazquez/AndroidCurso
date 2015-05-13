package vazquez.es.intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // abrir una nueva actividad ....navegar....
            //startActivity( new  Intent(this,MainActivity2Activity.class) );
            // metodo con respuesta......  intencion , requestcode: nos sirve para enlazar el onActivityResult, un bundle ( clave -valor)
            Intent intencion = new Intent(this, MainActivity2Activity.class);

            Informacion dato = null;
            dato = new Informacion("Ramon");
            intencion.putExtra("parametro1", dato);
            startActivityForResult(intencion, 0);
           //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 ) {
            // asi se quien es el que vuelve.
            if ( resultCode == Activity.RESULT_OK){
                    data.getExtras().getString("resultado");
            }
        }
    }
}

