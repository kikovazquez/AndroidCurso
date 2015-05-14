package vazquez.es.terremotos.utils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import vazquez.es.terremotos.R;
import vazquez.es.terremotos.modelo.Terremoto;

public class PruebasXML extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pruebas_xml);
        try {
            SAXParserFactory sf = SAXParserFactory.newInstance();
            SAXParser saxP = sf.newSAXParser();
            XMLReader xmlR = saxP.getXMLReader();

            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.atom");

            /**
            * Create the Handler to handle each of the XML tags.
            **/
            XMLHandler myXMLHandler = new XMLHandler();
            xmlR.setContentHandler(myXMLHandler);
            xmlR.parse(new InputSource(url.openStream()));


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView ejemplo[];
        int registros = XMLHandler.getData().size();
        ejemplo = new TextView[registros];
        List<Terremoto> datos = XMLHandler.getData();

        View layout = findViewById(R.id.layoutlimpio);

        for ( int i = 0 ; i < registros; i++) {

            ejemplo[i] = new TextView(this);
            ejemplo[i].setText(datos.get(i).getId());

            ((ViewGroup) layout).addView(ejemplo[i]);

        }

        setContentView(layout);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pruebas_xml, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
