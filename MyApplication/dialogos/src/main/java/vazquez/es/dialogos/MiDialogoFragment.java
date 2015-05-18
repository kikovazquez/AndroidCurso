package vazquez.es.dialogos;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;



/**
 * A simple {@link Fragment} subclass.
 */
public class MiDialogoFragment extends DialogFragment {
    private AlertDialog.Builder builder;

    public MiDialogoFragment() {
        // Required empty public constructor



    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // creamos la factoria .....
        builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Desea Continuar?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });



    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog alertDialog = builder.create();
        return alertDialog;

    }

    public void setOnclickListenerSi(DialogInterface.OnClickListener onClickListener){
        builder.setPositiveButton("Si",onClickListener);
    }

    public void setOnclickListenerNo(DialogInterface.OnClickListener onClickListener){
        builder.setNegativeButton("No", onClickListener);
    }


}
