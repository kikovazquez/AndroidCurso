package vazquez.es.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity implements View.OnClickListener {
    private Button buton1;
    private Button buton2;
    private Button buton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incializar();

    }

    private void incializar() {

        buton1 = (Button) findViewById(R.id.button);
        buton2 = (Button) findViewById(R.id.button2);
        buton3 =  (Button) findViewById(R.id.button3);
        buton1.setText("Hola");
        buton2.setText("que ases");
        /*metodo 1 */
        /*click en el boton 1 y cambio el texto */
        buton1.setOnClickListener(new MiOnClickListener(buton2));
        /*Metodo 2 */
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("app", "click boton 2!");
                buton1.setText("doy boton1");
            }
        });
        /* Metodo 3*/
        buton3.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        //if (view.getId() == buton3.getId()){
          if (view.equals(buton3)){
            buton1.setText("cambio tres");
              Log.i("app", "boton 3");

        }
    }
}
