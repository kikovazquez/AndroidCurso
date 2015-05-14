package vazquez.es.menucontextual;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity {
    private ListView tareasLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tareasLV = (ListView)findViewById(R.id.tareasListView);

        List<Tarea> datos = new LinkedList<>();

        datos.add(new Tarea("Correr", "Correr sin parar durante 10Km"));
        datos.add(new Tarea("Nadar", "Nadar en la piscina 50 vueltas"));
        datos.add(new Tarea("Andar en Bicicleta", "Robar la primera bici que pilles y correr sin que te cojan"));

        TareasAdapter adaptador = new TareasAdapter(this,R.layout.tareas_list_item,datos);

        tareasLV.setAdapter(adaptador);

        // registra el menu contextual...

        registerForContextMenu(tareasLV);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.tareasListView) {

            getMenuInflater().inflate(R.menu.menu_main,menu);

             int posicion = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
             //   Tarea tarea = (Tarea) ((AdapterView) v).getAdapter().getItem(posicion);
             Tarea tarea = (Tarea) tareasLV.getAdapter().getItem(posicion);
            menu.setHeaderTitle(tarea.getNombre());
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings ) {
            // hacemos lo que queramos.
            // en esta variable esta ..... menu... se accede desde el item.
            ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();
            int posicion = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            /*    -- esto no SE SI  esta bien .... getActionView .... resulta que si....
            View v = item.getActionView();
            Tarea tarea = (Tarea) ((AdapterView) v).getAdapter().getItem(posicion);
            */
            Tarea tarea = (Tarea) tareasLV.getAdapter().getItem(posicion);
            Toast.makeText(MainActivity.this ,"asdf",Toast.LENGTH_SHORT).show();


        }

        return super.onContextItemSelected(item);


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
