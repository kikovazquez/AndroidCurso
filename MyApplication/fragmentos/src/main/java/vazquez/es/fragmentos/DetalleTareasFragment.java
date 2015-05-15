package vazquez.es.fragmentos;


import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleTareasFragment extends Fragment {



    public DetalleTareasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View respuesta = (View) inflater.inflate(R.layout.fragment_detalle_tareas, container, false);
        return respuesta;
    }

    public void retrieve(Tarea miTarea){
        TextView tx1 = (TextView) getActivity().findViewById(R.id.nombre);
        TextView tx2 = (TextView) getActivity().findViewById(R.id.descripcion);
        TextView tx3 = (TextView) getActivity().findViewById(R.id.prioridad);
        TextView tx4 = (TextView) getActivity().findViewById(R.id.fecha);

        tx1.setText(miTarea.getNombre());
        tx2.setText(miTarea.getDescripcion());
        tx3.setText(String.valueOf(miTarea.getPrioridad()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy hh:mm:ss");
        tx4.setText(simpleDateFormat.format(miTarea.getFecha()));


    }

}
