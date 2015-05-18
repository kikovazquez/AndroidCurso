package vazquez.es.terremotos.controladores;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import vazquez.es.terremotos.R;

public class MenuHelp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_help);
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
}
