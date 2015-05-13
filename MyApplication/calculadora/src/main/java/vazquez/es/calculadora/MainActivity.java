package vazquez.es.calculadora;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private TextView resultado, resultadov;
    private Button[] botones ;
    private Button bigual, bmas, bmenos,bpor, bdiv, bdel;
    //private MotorCalculadora micalc;
    private MotorCalculadoraI micalc;
    private boolean operacion = true;
    Inicio  miapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        miapp = (Inicio) this.getApplication();
        micalc = miapp.getCalculadora();

        setContentView(R.layout.activity_main);
        inicializar();

    }

    private void inicializar() {

        resultado  =  (TextView) findViewById(R.id.resultado);
        resultadov = (TextView) findViewById(R.id.resultadov);
        botones    = new Button[10];
        botones[0] = (Button) findViewById(R.id.button0);
        botones[1] = (Button) findViewById(R.id.button1);
        botones[2] = (Button) findViewById(R.id.button2);
        botones[3] = (Button) findViewById(R.id.button3);
        botones[4] = (Button) findViewById(R.id.button4);
        botones[5] = (Button) findViewById(R.id.button5);
        botones[6] = (Button) findViewById(R.id.button6);
        botones[7] = (Button) findViewById(R.id.button7);
        botones[8] = (Button) findViewById(R.id.button8);
        botones[9] = (Button) findViewById(R.id.button9);



        bmas = (Button) findViewById(R.id.buttonmas);
        bmenos = (Button) findViewById(R.id.buttonmenos);
        bpor = (Button) findViewById(R.id.buttonpor);
        bdiv = (Button) findViewById(R.id.buttondiv);

        bdel = (Button) findViewById(R.id.buttonCE);
        bigual = (Button) findViewById(R.id.buttonigual);

        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("0");
                resultadov.setText("0");
                micalc.setTotalizado(0);
                micalc.setOperacion("");
                operacion = false;

            }
        });
        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                micalc.setOperacion("=");
                valor = micalc.calcula(resultado.getText().toString());
                resultadov.setText(String.valueOf(valor));
                resultado.setText("0");
                micalc.setTotalizado(valor);
                micalc.setOperfinal("=");
                operacion = false;


            }
        });

        bmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                resultadov.setText(resultadov.getText().toString() + "+");
                micalc.setOperacion("+");
                //valor = micalc.suma(resultado.getText().toString());
                valor = micalc.calcula(resultado.getText().toString());
                resultado.setText(String.valueOf(valor));
                micalc.setTotalizado(valor);
                micalc.setOperfinal("+");
                operacion=false;


            }
        });

        bmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                resultadov.setText(resultadov.getText().toString() + "-");
                micalc.setOperacion("-");
                //valor = micalc.resta(resultado.getText().toString());
                valor = micalc.calcula(resultado.getText().toString());
                resultado.setText(String.valueOf(valor));
                micalc.setTotalizado(valor);
                micalc.setOperfinal("-");
                operacion=false;




            }
        });
        bpor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                resultadov.setText(resultadov.getText().toString() + "*");
                micalc.setOperacion("*");
                //valor = micalc.multiplica(resultado.getText().toString());
                valor = micalc.calcula(resultado.getText().toString());
                resultado.setText(String.valueOf(valor));
                micalc.setTotalizado(valor);
                micalc.setOperfinal("*");
                operacion=false;



            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;

                micalc.setOperacion("/");
                resultadov.setText(resultadov.getText().toString() + "/");
                //valor = micalc.divide(resultado.getText().toString());
                valor = micalc.calcula(resultado.getText().toString());
                resultado.setText(String.valueOf(valor));
                micalc.setTotalizado(valor);
                micalc.setOperfinal("/");
                operacion=false;



            }
        });

        for (int i = 0; i < 10; i++) {
            botones[i].setOnClickListener(this);
        }
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
            String valor="";
            int valor2;
            boolean isnumber;
            if (resultado.getText().toString().equals("0")) {
                resultado.setText("");
                resultadov.setText("");
            }
            /* valor = ((Button)view).getText().toString(); */

            for (int  i = 0 ; i < 10; i++){
                if (view.equals(botones[i])){
                    valor = botones[i].getText().toString();
                }

            }

                if (operacion == true) {
                    resultado.setText(resultado.getText().toString() + valor);
                } else {
                    resultado.setText(valor);
                    operacion = true;

                }
                resultadov.setText(resultadov.getText().toString() + valor);



    }
}
