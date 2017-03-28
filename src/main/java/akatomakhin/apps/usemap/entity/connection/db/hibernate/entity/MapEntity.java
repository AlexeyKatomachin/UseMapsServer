package akatomakhin.apps.usemap.entity.connection.db.hibernate.entity;

import akatomakhin.apps.usemap.entity.map.Map;
import akatomakhin.apps.usemap.entity.map.entity.Location;

import javax.persistence.*;

@Entity
@Table(name = "map", schema = "userdb")
public class MapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "lat")
    private double lat;
    @Column(name = "lng")
    private double lng;
    @Column(name = "accuracy")
    private double accuracy;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void setMap(Map map) {
        this.accuracy = map.getAccuracy();
        this.lng = map.getLocation().getLng();
        this.lat = map.getLocation().getLat();
    }

    public Map getMap() {
        Map map = new Map();
        Location location = new Location();
        map.setAccuracy(accuracy);
        location.setLng(lng);
        location.setLat(lat);
        map.setLocation(location);
        return map;
    }
}
