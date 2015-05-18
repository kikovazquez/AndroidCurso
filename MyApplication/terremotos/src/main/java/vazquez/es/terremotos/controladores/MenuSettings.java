package vazquez.es.terremotos.controladores;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.LinkedList;

import vazquez.es.terremotos.R;
import vazquez.es.terremotos.utils.spinners;


public class MenuSettings extends ActionBarActivity {
    private Spinner dropdownVelocidaRefresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_settings);
        inicializar();
    }

    private void inicializar() {
        dropdownVelocidaRefresco = (Spinner) findViewById(R.id.velocidadrefrescosp);
        LinkedList<spinners> magnitudes = new LinkedList<spinners>();
        //La poblamos con los ejemplos
        magnitudes.add(new spinners(1, "Cada minuto"));
        magnitudes.add(new spinners(5, "Cada 5 minutos"));
        magnitudes.add(new spinners(30, "Cada 30 minutos"));
        magnitudes.add(new spinners(60, "Cada hora"));

        //Creamos el adaptador
        ArrayAdapter<spinners> spinner_adapter = new ArrayAdapter<spinners>(this, android.R.layout.simple_spinner_item, magnitudes);
        //Añadimos el layout para el menú y se lo damos al spinner
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownVelocidaRefresco.setAdapter(spinner_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filtro_terremotos, menu);

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

            Intent intencion = new Intent(this, MenuSettings.class);
            //startActivity(intencion);
            startActivityForResult(intencion,1);


            return true;
        }
        if (id == R.id.action_aboutit) {

        }
        if (id == R.id.action_help) {
            Intent intencion = new Intent(this, MenuHelp.class);
            startActivity(intencion);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent respuesta = null;
        respuesta = new Intent();
        respuesta.putExtra("resultado","todo ok");
        setResult(Activity.RESULT_OK,respuesta);
        finish();

    }
}


