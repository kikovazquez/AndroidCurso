package vazquez.es.viewadapters;

import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();


    }

    private void inicializar() {

        prueba = (ListView) findViewById(R.id.listView);


        /*
        ListAdapter adaptador = null;
        String[] kiko = new String[10];
        for (int i = 0 ; i < 10 ; i++) {
            kiko[i] = "Soy el numero " + i ;
        }
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kiko);
        prueba.setAdapter(adaptador);
        */

        ConectorAdaptador adaptador =  null;
        List<Registro> datos;

        datos = new LinkedList<>();

        for (int i = 0 ; i < 10 ; i++ ) {

            datos.add( i , new Registro( i  +"" , i*2 +""));
        }

        adaptador = new ConectorAdaptador(this,R.layout.detalle_list_item,datos);
        prueba.setAdapter(adaptador);




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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
