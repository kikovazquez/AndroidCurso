package vazquez.es.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;


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
            Intent intencion = new Intent(this, ConfiguracionActivity.class);
            startActivity(intencion);
            return true;
        }
        else if ( id == R.id.leer_settings) {
            SharedPreferences misPref = PreferenceManager.getDefaultSharedPreferences(this);

            String frecuencia =  misPref.getString("frecuencias", "0");
            String url = misPref.getString("url", "kiko");
            String mensaje = "los valores son " + frecuencia + " y " +  url;

            Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();



        }

        return super.onOptionsItemSelected(item);
    }
}
