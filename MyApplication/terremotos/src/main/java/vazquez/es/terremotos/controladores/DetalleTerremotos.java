package vazquez.es.terremotos.controladores;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import vazquez.es.terremotos.R;
import vazquez.es.terremotos.controladores.parametros.BuscaTerremoto;
import vazquez.es.terremotos.modelo.Terremoto;
import vazquez.es.terremotos.utils.TerremotosAdapter;


public class DetalleTerremotos extends ActionBarActivity {
    private ListView terremotosLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_terremotos);
        incializar();

    }

    private void incializar() {
        Intent recibido = getIntent();
        BuscaTerremoto parstd = (BuscaTerremoto) recibido.getExtras().getSerializable("parstd");

        terremotosLV = (ListView)findViewById(R.id.terremotoListView);
        List<Terremoto> datos = new LinkedList<>();

        datos.add(new Terremoto(1, "Terremoto 1", 3));
        datos.add(new Terremoto(2, "Terremoto 2", 4));
        datos.add(new Terremoto(3, "Terremoto 3", 2));


        TerremotosAdapter adaptador = new TerremotosAdapter(this,R.layout.terremoto_list_item,datos);

        terremotosLV.setAdapter(adaptador);

        // registra el menu contextual...

        registerForContextMenu(terremotosLV);




        // TODO hacemos el retrieve del listview.

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_terremotos, menu);
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
}
