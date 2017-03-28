package akatomakhin.apps.usemap.entity.map.entity;

public class Location {
    /* mandatory data*/
    private double lat;
    private double lng;

    /* setters and getters*/
    public void setLat (double lat){
        this.lat = lat;
    }

    public double getLat(){
        return lat;
    }

    public void setLng(double lng){
        this.lng = lng;
    }

    public double getLng(){
        return lng;
    }
}
