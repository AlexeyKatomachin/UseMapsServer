package akatomakhin.apps.usemap.entity.map.geolocation.client.request.mobile.net.entity.gsm;

public class CellTowers {
    /* mandatory data*/
    private int cellID;
    private int locationAreaCode;
    private int mobileCountryCode;
    private int mobileNetworkCode;

    /* optional data*/
    private int age = 0;
    private int signalStrength = -60;
    private int timingAdvance = 15;

    /* setters and getters*/
    public void setCellID(int cellID){
        this.cellID = cellID;
    }

    public int getCellID(){
        return cellID;
    }

    public void setLocationAreaCode(int locationAreaCode){
        this.locationAreaCode = locationAreaCode;
    }

    public int getLocationAreaCode(){
        return locationAreaCode;
    }

    public void setMobileCountryCode(int mobileCountryCode){
        this.mobileCountryCode = mobileCountryCode;
    }

    public int getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileNetworkCode(int mobileNetworkCode){
        this.mobileNetworkCode = mobileNetworkCode;
    }

    public  int getMobileNetworkCode (){
        return mobileNetworkCode;
    }

    public void setAge (int age){
        this.age = age;
    }

    public int getAge (){
        return age;
    }

    public void setSignalStrength (int signalStrength){
        this.signalStrength = signalStrength;
    }

    public int getSignalStrength(){
        return signalStrength;
    }

    public void setTimingAdvance(int timingAdvance){
        this.timingAdvance = timingAdvance;
    }

    public int getTimingAdvance(){
        return timingAdvance;
    }
}
