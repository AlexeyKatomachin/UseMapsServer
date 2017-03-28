package akatomakhin.apps.usemap.entity.map;

import akatomakhin.apps.usemap.entity.map.entity.Location;

public class Map {
    /* mandatory data*/
    private Location location;
    private double accuracy;

    /* setters and getters*/
    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

    public void setAccuracy(double accuracy){
        this.accuracy = accuracy;
    }

    public double getAccuracy(){
        return accuracy;
    }
}
