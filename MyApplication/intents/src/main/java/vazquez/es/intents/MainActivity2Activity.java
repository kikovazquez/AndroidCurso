package vazquez.es.intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;


public class MainActivity2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Intent recibido = getIntent();
        Informacion kiko = (Informacion) recibido.getExtras().getSerializable("parametro1");
        // kiko.getNombre(); hay que castear siempre .... cuando los objetos son diferentes



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
            //startActivity( new Intent(this,MainActivity.class));
            Intent respuesta = null;
            respuesta = new Intent();
            respuesta.putExtra("resultado","todo ok");
            setResult(Activity.RESULT_OK,respuesta);
            finish();

            //return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
