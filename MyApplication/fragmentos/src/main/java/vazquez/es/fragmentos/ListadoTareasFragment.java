package vazquez.es.fragmentos;


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
public class ListadoTareasFragment extends Fragment {
    private TextView tx1;
    private TextView tx2;

    public ListadoTareasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // cuando la actividad ha creado los fragmentos.
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado_tareas, container, false);
    }


    public void registerListViewOnClick(View.OnClickListener listener){
        ListView lvTareas = (ListView) getActivity().findViewById(R.id.tareasListView);
        lvTareas.setOnClickListener(listener);
    }


}
