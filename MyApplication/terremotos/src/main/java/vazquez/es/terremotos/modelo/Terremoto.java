package vazquez.es.terremotos.modelo;

import android.graphics.Point;
import android.location.Location;

import java.util.Date;

/**
 * Created by Kiko on 14/05/2015.
 */
public class Terremoto {
    private int id;
    private String title;
    private Date updated;
    private String link;
    private String sumary;
    private Point georsspoint;
    private int georsselev;
    private String age;
    private String magnitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }

    public Point getGeorsspoint() {
        return georsspoint;
    }

    public void setGeorsspoint(Point georsspoint) {
        this.georsspoint = georsspoint;
    }

    public int getGeorsselev() {
        return georsselev;
    }

    public void setGeorsselev(int georsselev) {
        this.georsselev = georsselev;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }
}
