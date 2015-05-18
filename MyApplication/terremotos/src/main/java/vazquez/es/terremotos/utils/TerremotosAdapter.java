package vazquez.es.terremotos.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vazquez.es.terremotos.R;
import vazquez.es.terremotos.modelo.Terremoto;

/**
 * Created by androidm on 18/05/2015.
 */
public class TerremotosAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Terremoto> collecion;

    public List<Terremoto> getCollecion(String user, String password) {
        return collecion;
    }

    public TerremotosAdapter(Context context, int layout, List<Terremoto> collecion) {
        this.context = context;
        this.layout = layout;
        this.collecion = collecion;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
        }

        final Terremoto item = (Terremoto)getItem(position);

        TextView txNombre = (TextView) convertView.findViewById(R.id.tituloTerremoto);
        TextView txDescripcion = (TextView) convertView.findViewById(R.id.magnitudTerremoto);
        /* Button button = (Button) convertView.findViewById(R.id.button); */
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        TareasAdapter.this.context,
                        "El item pulsado es: " + item.getNombre(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
        */
        txNombre.setText(item.getTitle());
        txDescripcion.setText(item.getMagnitude());

        return convertView;

    }
}
