package vazquez.es.internet;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by androidm on 19/05/2015.

    UTILIZAREMOS Void como nulo.


 */

public class DescargaFichero extends AsyncTask<String,Integer,Bitmap> {
    private ImageView imageview;
    private ProgressDialog progresDialog;


    public DescargaFichero() {
    }

    public DescargaFichero(ImageView imageview,ProgressDialog pd) {
        this.imageview = imageview;
        this.progresDialog = pd;

    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        InputStream is = null;
        try {

            URL url = new URL(strings[0]);
            // hay una implementacion especifica para http://
            //URLConnection urlConnection = url.openConnection();
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            is = urlConnection.getInputStream();

            int tamanyoImagen = urlConnection.getContentLength();
            byte[] buffer = new byte[512];
            byte[] bufferImagen = new byte[tamanyoImagen];

             for ( int bytesLeidos =  0 ; bytesLeidos < tamanyoImagen ; ) {

                 int bytesLeidos1 = is.read(buffer);
                 // lo vuelco a la imange
                 System.arraycopy(buffer,0, bufferImagen, bytesLeidos, bytesLeidos1);

                 bytesLeidos += bytesLeidos1;

                 publishProgress(bytesLeidos,tamanyoImagen);


             }

            return BitmapFactory.decodeByteArray(bufferImagen,0,tamanyoImagen);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    // se ejecutan en el MainThread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progresDialog.setTitle("mira como voy de rapido");
        progresDialog.setMax(100);
        progresDialog.setProgress(0);
        progresDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progresDialog.show();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageview.setImageBitmap(bitmap);
        progresDialog.hide();


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int progreso = 100* (values[0] / values[1]);
        progresDialog.setProgress(values[0]);





    }

}

