package vazquez.es.viewadapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;

    }
}
