package vazquez.es.terremotos.controladores;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import vazquez.es.terremotos.R;
import vazquez.es.terremotos.controladores.parametros.BuscaTerremoto;
import vazquez.es.terremotos.utils.MiDatePickerDialog;
import vazquez.es.terremotos.utils.PruebasXML;
import vazquez.es.terremotos.utils.spinners;


public class FiltroTerremotos extends ActionBarActivity implements View.OnClickListener {
    private Button buscar;
    private TextView fechaTxt;
    private Date fechaBuscar;
    private Spinner magnitudBuscar;
    private Button XML;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_terremotos);
        Inicializar();

    }

    private void Inicializar() {
        buscar = (Button) findViewById(R.id.buscar) ;
        buscar.setOnClickListener(this);
        fechaTxt = (TextView) findViewById(R.id.fecha);
        fechaTxt.setOnClickListener(this);
        XML = (Button) findViewById(R.id.xmlButton);
        XML.setOnClickListener(this);
        magnitudBuscar = (Spinner) findViewById(R.id.magnitudsp);
        LinkedList<spinners> magnitudes = new LinkedList<spinners>();
        //La poblamos con los ejemplos
        magnitudes.add(new spinners(1, getString(R.string.magnitud_terremoto)+ " 1" ));
        magnitudes.add(new spinners(2, getString(R.string.magnitud_terremoto)+ " 2"));
        magnitudes.add(new spinners(3, getString(R.string.magnitud_terremoto)+ " 3"));
        magnitudes.add(new spinners(4, getString(R.string.magnitud_terremoto)+ " 4"));
        magnitudes.add(new spinners(5, getString(R.string.magnitud_terremoto)+ " 5"));
        magnitudes.add(new spinners(6, getString(R.string.magnitud_terremoto)+ " 6"));
        magnitudes.add(new spinners(7, getString(R.string.magnitud_terremoto)+ " 7"));

        //Creamos el adaptador
        ArrayAdapter<spinners> spinner_adapter = new ArrayAdapter<spinners>(this, android.R.layout.simple_spinner_item, magnitudes);
        //Añadimos el layout para el menú y se lo damos al spinner
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        magnitudBuscar.setAdapter(spinner_adapter);


        final Calendar calendar = Calendar.getInstance();
        int anyo = calendar.get(Calendar.YEAR);
        int mes =  calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        fechaTxt.setText(new StringBuilder()
                .append(dia).append("/")
                .append(mes + 1).append("/")
                .append(anyo));




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
    public void onClick(View view) {

        if (view.getId() == R.id.fecha) {
            MiDatePickerDialog newFragment = new MiDatePickerDialog();
            newFragment.show(getFragmentManager(), "datePicker");
        }



        /* BOTON buscar abre el listado pasandole los parametros de busqueda*/
        if (view.equals(buscar)) {

            BuscaTerremoto parstd = null;
            parstd = new BuscaTerremoto();
            parstd.setMagnitudTerremoto((int) magnitudBuscar.getSelectedItemId());
            parstd.setFechaABuscar(fechaBuscar);

            Intent intencion = new Intent(this, ListaTerremotos.class);
            intencion.putExtra("parstd", parstd);
            startActivity(intencion);
        }
        if (view.equals(XML)){
            Intent intencion = new Intent(this, PruebasXML.class);
            startActivity(intencion);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            /* TODO: vuelvo de los settings , deberia reconfigurar el alarm manager , si ha modificado algo*/
        }
    }

}
