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



}
