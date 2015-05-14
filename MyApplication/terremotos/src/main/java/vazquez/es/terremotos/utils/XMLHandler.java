package vazquez.es.terremotos.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

import vazquez.es.terremotos.modelo.Terremoto;

/**
 * Created by Kiko on 14/05/2015.
 */
public class XMLHandler extends DefaultHandler {
    String valorElemento = null;
    Boolean elementOn = false;
    Terremoto tempTerremoto = null;
    public static List<Terremoto> data = null;

    public XMLHandler() {
        data = new LinkedList<>();
    }

    public static List<Terremoto> getData() {
        return data;
    }

    public static void setData(List<Terremoto> data) {
        XMLHandler.data = data;
    }





    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementOn = true;
        if (localName.equalsIgnoreCase("entry")) {
            tempTerremoto = new Terremoto();
        }
        /**
         * We can get the values of attributes for eg. if the CD tag had an attribute( <CD attr= "band">Akon</CD> )
         * we can get the value "band". Below is an example of how to achieve this.
         *
         * String attributeValue = attributes.getValue("attr");
         * data.setAttribute(attributeValue);
         *
         * */
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementOn = false;
        if ( localName.equalsIgnoreCase("entry")) {
            data.add(tempTerremoto);
        }
        else
        if (localName.equalsIgnoreCase("id")){
            tempTerremoto.setId(Integer.parseInt(valorElemento));
        }
        else
        if (localName.equalsIgnoreCase("title")){
            tempTerremoto.setTitle(valorElemento);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementOn) {
            valorElemento = new String(ch, start, length);
            elementOn = false;
        }
    }
}
