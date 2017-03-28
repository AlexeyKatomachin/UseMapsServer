package akatomakhin.apps.usemap.entity.map.geolocation.client.request;

import akatomakhin.apps.usemap.entity.map.geolocation.client.request.mobile.net.entity.gsm.CellTowers;
import akatomakhin.apps.usemap.entity.map.geolocation.client.request.wifi.WiFiData;

import java.util.ArrayList;


public class LocationData {
    /* mandatory data*/
    private int homeMobileCountryCode;
    private int homeMobileNetworkCode;
    private String radioType;
    private String carrier;
    private String considerIp;
    private ArrayList<CellTowers> cellTowers = new ArrayList<CellTowers>();
    private ArrayList<WiFiData> wifiAccessPoints = new ArrayList<WiFiData>();

    /* setters and getters*/
    public void setHomeMobileCountryCode(int homeMobileCountryCode) {
        this.homeMobileCountryCode = homeMobileCountryCode;
    }

    public int getHomeMobileCountryCode() {
        return homeMobileCountryCode;
    }

    public void setHomeMobileNetworkCode(int homeMobileNetworkCode) {
        this.homeMobileNetworkCode = homeMobileNetworkCode;
    }

    public int getHomeMobileNetworkCode() {
        return homeMobileNetworkCode;
    }

    public void setRadioType(String radioType) {
        this.radioType = radioType;
    }

    public String getRadioType() {
        return radioType;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setConsiderIp(String considerIp) {
        this.considerIp = considerIp;
    }

    public String getConsiderIp() {
        return considerIp;
    }

    public void setCellTowers(CellTowers cellTowers) {
        this.cellTowers.add(cellTowers);
    }

    public ArrayList<CellTowers> getCellTowers() {
        return cellTowers;
    }

    public void setWifiAccessPoints(WiFiData wifiAccessPoint) {
        wifiAccessPoints.add(wifiAccessPoint);
    }

    private ArrayList<WiFiData> getWifiAccessPoints(){
        return wifiAccessPoints;
    }
}
