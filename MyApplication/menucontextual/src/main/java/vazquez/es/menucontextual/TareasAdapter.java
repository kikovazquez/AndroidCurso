package vazquez.es.menucontextual;

/**
 * Created by androidm on 14/05/2015.
 */

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by androidm on 13/05/2015.
 */
public class TareasAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Tarea> collecion;

    public List<Tarea> getCollecion(String user, String password) {
        return collecion;
    }

    public TareasAdapter(Context context, int layout, List<Tarea> collecion) {
        this.context = context;
        this.layout = layout;
        this.collecion = collecion;
    }

    @Override
    public int getCount() {
        return collecion.size();
    }

    @Override
    public Object getItem(int position) {
        return collecion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
        }

        final Tarea item = (Tarea)getItem(position);

        TextView txNombre = (TextView) convertView.findViewById(R.id.txNombre);
        TextView txDescripcion = (TextView) convertView.findViewById(R.id.txDescripcion);
        Button button = (Button) convertView.findViewById(R.id.button);

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

        txNombre.setText(item.getNombre());
        txDescripcion.setText(item.getDescripcion());

        return convertView;
    }

}
