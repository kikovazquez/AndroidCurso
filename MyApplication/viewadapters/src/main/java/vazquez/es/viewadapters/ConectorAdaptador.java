package vazquez.es.viewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by androidm on 13/05/2015.
 */
public class ConectorAdaptador extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Registro> coleccion;

    public ConectorAdaptador() {
    }

    public ConectorAdaptador(Context context, int layout, List<Registro> coleccion) {
        this.context = context;
        this.layout = layout;
        this.coleccion = coleccion;
    }

    @Override
    public int getCount() {

        return coleccion.size();
    }

    @Override
    public Object getItem(int i) {
        return coleccion.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            // utilizamos el inflador del registro.
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layoutInflater.inflate(layout, null);
        }

            final Registro datos = (Registro) getItem(i);

        TextView nombre = (TextView) convertView.findViewById(R.id.uno);
        TextView desc   = (TextView) convertView.findViewById(R.id.dos);
        Button   boton = (Button) convertView.findViewById(R.id.button);

            nombre.setText(datos.getUno());
            desc.setText(datos.getDos());

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = 0;
                    Toast.makeText(ConectorAdaptador.this.context, datos.getUno() + " registro-->  " + getItemId(x)  ,Toast.LENGTH_SHORT).show();


                }
            });

        return convertView;


    }
}
