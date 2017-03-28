package akatomakhin.apps.usemap.entity.map.geolocation.client.request.wifi;

public class WiFiData {
    /* mandatory data*/
    private String macAddress;

    /* optional data*/
    private int signalStrength = -43;
    private int age = 0;
    private int channel = 11;
    private int signalToNoiseRatio = 0;

    /* setters and getters*/
    public void setMacAddress (String macAddress){
        this.macAddress = macAddress;
    }

    public String getMacAddress (){
        return macAddress;
    }

    public void setSignalStrength(int signalStrength){
        this.signalStrength = signalStrength;
    }

    public int getSignalStrength(){
        return signalStrength;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge (){
        return  age;
    }

    public void setChannel(int channel){
        this.channel = channel;
    }

    public int getChannel(){
        return channel;
    }

    public void setSignalToNoiseRatio (int signalToNoiseRatio){
        this.signalToNoiseRatio = signalToNoiseRatio;
    }

    public int getSignalToNoiseRatio(){
        return signalToNoiseRatio;
    }
}
