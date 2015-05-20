package vazquez.es.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by androidm on 20/05/2015.
 */
public class TerremotoBaseDeDatos extends SQLiteOpenHelper {
    private Context context;

    public TerremotoBaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String[] queries = context.getResources().getStringArray(R.array.creacionbd);


        ejecutarSql(sqLiteDatabase, queries);

    }

    private void ejecutarSql(SQLiteDatabase sqLiteDatabase, String[] queries) {

        sqLiteDatabase.beginTransaction();

        for (String s : queries) {
            sqLiteDatabase.execSQL(s);
        }
        ;
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            //TODO en funcion del old version y new version .... hacemos todo .....
    }

}

