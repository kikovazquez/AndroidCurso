package vazquez.es.parsexml;

import android.os.AsyncTask;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by androidm on 20/05/2015.
 */
public class DescargarXML extends AsyncTask<String, Void, List<Terremoto>> {
    private ListView listView;



    public DescargarXML(ListView listView) {
        this.listView = listView;
    }

    @Override
    protected List<Terremoto> doInBackground(String... strings) {

        URL url = null;
        InputStream is = null;

        try {
            url = new URL(strings[0]);
            URLConnection urlConnection = url.openConnection();
            is = urlConnection.getInputStream();
            return parsearXML(is);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Terremoto> parsearXML(InputStream is) throws XmlPullParserException, IOException, ParseException {

        LinkedList<Terremoto> respuesta = new LinkedList<>();


        // para parsear con pull
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(is, "UTF-8");

        int event = xmlPullParser.getEventType();
        Terremoto terremoto = null;

        while (event != xmlPullParser.END_DOCUMENT){

            String tag = xmlPullParser.getName();

            if (event == xmlPullParser.START_TAG) {
                if (tag.equals("entry")) {
                    terremoto = new Terremoto();
                } else {

                    if ( terremoto != null && tag.equals("id")) {
                            terremoto.setId(xmlPullParser.nextText());
                    }
                    if ( terremoto != null && tag.equals("title")) {
                            String[] split = xmlPullParser.nextText().split(" - ");

                            String titulo = split[1];
                            terremoto.setTitulo(titulo);

                            String magnitud =split[0].split(" ")[1];
                            terremoto.setMagnitud(Float.parseFloat(magnitud));
                            //terremoto.setTitulo("KIKO: " + magnitud + " KIKO");


                    }

                    if ( terremoto != null && tag.equals("updated")) {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                        Date date = null;
                        date = dateFormat.parse(xmlPullParser.nextText());
                        terremoto.setFecha(date);
                    }
                    if ( terremoto != null && tag.equals("link")) {
                        terremoto.setLink(xmlPullParser.getAttributeValue(null, "href"));

                    }
                    if ( terremoto != null && tag.equals("point")) {

                        String[] latlon = xmlPullParser.nextText().split(" ");
                        terremoto.setLatitud(Float.valueOf(latlon[0]));
                        terremoto.setLongitud(Float.valueOf(latlon[1]));

                    }

                }
            }

            if (event == xmlPullParser.END_TAG) {
                if (tag.equals("entry")) {
                    respuesta.add(terremoto);
                    terremoto = null;
                }
            }

            event = xmlPullParser.next();
        }


        return respuesta;
    }

    @Override
    protected void onPostExecute(List<Terremoto> terremotos) {
        super.onPostExecute(terremotos);

        ((ArrayAdapter<Terremoto>) listView.getAdapter()).addAll(terremotos);
        ((ArrayAdapter<Terremoto>) listView.getAdapter()).notifyDataSetChanged();



    }
}
